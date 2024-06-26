// API schemas

export type SignUpDto = {
  firstName: string;
  lastName: string;
  phone: string;
  password: string;
  login: string;
  prefLanguage: string;
  joiningDate: Date;
  privacy: string;
  status: string;
  areaId: string;
  email: string;
};

export type CredentialsDto = {
  login: string;
  password: string;
};

export type UserDto = {
  userID: number;
  token: string;
  firstName: string;
  lastName: string;
  phone: string;
  login: string;
  email: string;
  prefLanguage: string;
  status: string;
};

export type JWTDto = {
  JWT: string;
};

export type ResetDto = {
  flag: string;
};

export type NewPasswordDto = {
  resetToken: string;
  newPassword: string;
};

export type ProductDto = {
  advtTitle: string;
  postDate: number;
  expirtyDate: Date;
  phone: string;
  firstName: string;
  lastName: string;
  email: string;
  productID: string;
  userId: string;
  productName: string;
  productDescription: string;
  price: number;
  categoryName: string;
  areaId: number;
  areaName: string;
  city: string;
  state: string;
  country: string;
  categoryId: number;

  images: string[];
};

export type ProductReal = {
  productID: string;
  name: string;
  description: string;
  price: string;
  area: TArea;
  category: TCategory;

  // gadgets
  manufacture: string;
  year_of_purchase: string;
  model_name: string;
  gadget_type: string;

  // furniture
  furniture_type: string;
  condition: string;

  // books
  author: string;
  book_condition: string;
  year_of_public: string;

  // kitchen appliances
  appliance_type: string;
};

export type TCategory = {
  categoryID: string;
  name: string;
};

export type TArea = {
  areaID: string;
  areaName: string;
  city: string;
  state: string;
  country: string;
};

export type PurchaseDto = {
  purchaseID: string;
  buyerID: string;
  sellerID: string;
  advertisementID: string;
};

export type ImageDto = {
  imageId: string;
  id: number;
  name: string;
  imageType: 'product' | 'user';
};
