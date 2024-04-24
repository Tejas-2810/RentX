import {Table, Tag} from 'antd';
import {useWishlist} from './utils';
import wishlistStyle from './wishlist.module.less';
import {useNavigate} from 'react-router-dom';

export const WishlistPage = () => {
  const [wishlistProducts, , removeWishlist] = useWishlist();
  const navigate = useNavigate();

  return (
    <div className={wishlistStyle.container}>
      <h4>Your wishlist</h4>

      <Table
        className="mt-5"
        pagination={false}
        columns={[
          {
            title: 'Image',
            render: (record) => (
              <img src={record.images?.[0]} className="w-56 object-cover" />
            ),
          },
          {
            title: 'Name',
            dataIndex: 'name',
          },
          {
            title: 'Category',
            dataIndex: 'category',
            render: (record) => record.name,
          },
          {
            title: 'Location',
            dataIndex: 'area',
            render: (record) => record.city,
          },
          {
            title: 'Price',
            dataIndex: 'price',
            render: (price) => <>{price}$</>,
          },
          {
            title: 'Action',
            render: (record) => (
              <Tag
                color="red"
                onClick={(e) => {
                  e.preventDefault();
                  e.stopPropagation();
                  removeWishlist(record);
                }}
                className="cursor-pointer"
              >
                Remove
              </Tag>
            ),
          },
        ]}
        dataSource={wishlistProducts}
        onRow={(record) => {
          return {
            onClick: () => {
              navigate(`/product/${record.productID}`);
            },
          };
        }}
      />
    </div>
  );
};
