import { ProductType } from "./ProductType";


export class Product{

    productId:number = 0;

    name:String = '';

    type:ProductType = ProductType.FRUIT;

    price:number = 0.0;

    availableQuantity:number = 0;

    partnerId:number = 0;
}