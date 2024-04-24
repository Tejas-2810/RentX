import {ProductDto} from '@src/lib/api-schemas';
import {authHeader} from '@src/queries/payment';
import {useMutation} from 'react-query';

export const useCreateCustomer = () =>
  useMutation(
    (email: string): Promise<{id: string}> =>
      fetch('https://api.stripe.com/v1/customers', {
        method: 'POST',
        headers: {
          ...authHeader,
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({
          email,
        }),
      }).then((res) => res.json()),
  );

export const useCreatePaymentIntent = () =>
  useMutation(
    ({
      data: {product, customerId, tokenId},
    }: {
      data: {
        product: ProductDto;
        customerId: string;
        tokenId: string;
      };
    }) => {
      return fetch('https://api.stripe.com/v1/payment_intents', {
        headers: {
          ...authHeader,
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        method: 'POST',
        body: new URLSearchParams({
          amount: `${product?.price * 100}`,
          currency: 'cad',
          customer: customerId,
          'payment_method_data[type]': 'card',
          'payment_method_data[card][token]': tokenId,
          confirm: 'true',
          return_url: window.location.href,
          [`metadata[productId]`]: product?.productID,
        }),
      }).then((res) => res.json());
    },
  );
