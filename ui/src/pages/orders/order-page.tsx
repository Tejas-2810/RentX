import {useUserContext} from '@src/lib/store/user/consumer';
import {queries} from '@src/queries';
import {useQuery} from 'react-query';

export const OrderPage = () => {
  const {user} = useUserContext();

  const {data: stripeCustomer} = useQuery({
    ...queries.payments.customer(user?.login || ''),
    enabled: !!user?.login,
  });

  const {data: payments} = useQuery({
    ...queries.payments.intents(stripeCustomer?.id || ''),
    enabled: !!stripeCustomer?.id,
    staleTime: 10000,
  });

  console.log(payments);

  return <>Hello</>;
};
