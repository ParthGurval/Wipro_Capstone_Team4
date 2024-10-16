import { PaymentStatus } from "./PaymentStatus";


export class Payment{

    payment_id:number = 0;

    order_id:number = 0;

    payment_date:Date = new Date();

    amount:number = 0.0;

    payment_method:String = '';

    status:PaymentStatus = PaymentStatus.PENDING;
}