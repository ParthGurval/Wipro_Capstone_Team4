import { Rating } from "./Rating";


export class RatingDetails {
    review_id:number = 0;

    customerId:number = 0;

    partnerId:number = 0;

    rating:Rating = Rating.ONE;

    review_text:String = '';  
}