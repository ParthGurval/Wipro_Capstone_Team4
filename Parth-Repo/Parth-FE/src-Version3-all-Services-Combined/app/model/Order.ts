import { OrderStatus } from "./OrderStatus";


export class Order {
    order_id:number = 0;  

    customerId:number = 0;  

    partnerId:number = 0;  

    order_date:Date = new Date();  

    total_amount:number = 0.0;  

    status:OrderStatus = OrderStatus.PENDING;  
}