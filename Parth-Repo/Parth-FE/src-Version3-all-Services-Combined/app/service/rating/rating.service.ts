import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RatingDetails } from 'src/app/model/RatingReview';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  private apiUrl = 'http://localhost:8084/api/ratingReviews'; 

  constructor(private http: HttpClient) {}

  
  createRatingReview(ratingDetails: RatingDetails): Observable<RatingDetails> {
    return this.http.post<RatingDetails>(`${this.apiUrl}/createRatingReview`, ratingDetails);
  }

  
  getRatingReviewById(reviewId: number): Observable<RatingDetails> {
    console.log("Review Details ID Fetched: " +reviewId );
    return this.http.get<RatingDetails>(`${this.apiUrl}/getbyid/${reviewId}`);
  }

 
  getAllRatingReviews(): Observable<RatingDetails[]> {
    return this.http.get<RatingDetails[]>(`${this.apiUrl}/getallRatingReviews`);
  }

  
  updateRatingReview(ratingDetails: RatingDetails): Observable<RatingDetails> {
    return this.http.put<RatingDetails>(`${this.apiUrl}/updateRatingReview`, ratingDetails);
  }

  
  deleteRatingReview(reviewId: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/deletebyid/${reviewId}`);
  }

  // Get ratings by customer ID
  getRatingByCustomerId(customerId: number): Observable<RatingDetails[]> {
    console.log("customer Details ID Fetched: " + customerId);
    return this.http.get<RatingDetails[]>(`${this.apiUrl}/getRatingByCust/${customerId}`);
  }

  // Get ratings by farm partner ID
  getRatingByFarmPartnerId(partnerId: number): Observable<RatingDetails[]> {
    console.log("farmpartner Details ID Fetched: " + partnerId);
    return this.http.get<RatingDetails[]>(`${this.apiUrl}/getRatingByFarmPartner/${partnerId}`);
  }
}
