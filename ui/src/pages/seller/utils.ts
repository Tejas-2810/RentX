import * as yup from 'yup';

export const addProductSchema = yup.object({
  name: yup.string().required(),
  description: yup.string().required(),
  price: yup.number().required(),
  area: yup
    .object({
      areaID: yup.number().optional(),
      city: yup.string().required(),
    })
    .required(),
  category: yup
    .object({
      categoryID: yup.number().optional(),
      name: yup.string().required(),
    })
    .required(),
});
