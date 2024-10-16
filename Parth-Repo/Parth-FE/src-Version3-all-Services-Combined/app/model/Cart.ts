export class Cart{

    cart_id:number = 0;

    customerId:number = 0;
    
    productId:number[] = [];

    quantity:number = 0;

    price:number = 0.0;
    
    createdAt: Date = new Date();

    updatedAt: Date = new Date();
}