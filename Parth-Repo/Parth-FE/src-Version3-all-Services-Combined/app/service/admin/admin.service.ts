import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from 'src/app/model/admin';
import { Customer } from 'src/app/model/customer';
import { FarmPartner } from 'src/app/model/farmPartner';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  baseURL:string = 'http://localhost:9191/api/admin';

  getAllCust():Observable<Admin[]> {

    return this.http.get<Admin[]>(this.baseURL + "/getAllCustomers");
  }

  findCust(customerId:number):Observable<Customer> {

    console.log("CustomerId Fetched through Admin" + customerId);
    return this.http.get<Customer>(this.baseURL + "/getCustomerById/" + customerId);
  }

  deleteCust(customerId:number):Observable<string> {

    return  this.http.delete<string>(this.baseURL + `/deleteCustomer/${customerId}`);
  }

  getAllFarmPart():Observable<FarmPartner[]> {

    return this.http.get<FarmPartner[]>(this.baseURL + "/getAllFarmpPartners");
  }

  findFarmPart(partnerId:number):Observable<FarmPartner> {

    console.log("FarmPartnerId Fetched Through Admin" + partnerId);
    return this.http.get<FarmPartner>(this.baseURL + "/getFarmPartById/" + partnerId);
  }

  /*
  findCust(adminId:number):Observable<Admin> {

    console.log("admin find customer service" + adminId);
    return this.http.get<Admin>(this.baseURL + "/getCustomerById/" + adminId);
  }

  deleteCust(adminId:number):Observable<string> {

    return  this.http.delete<string>(this.baseURL + `/deleteCustomer/${adminId}`);
  }

  getAllFarmPart():Observable<Admin[]> {

    return this.http.get<Admin[]>(this.baseURL + "/getAllFarmpPartners");
  }

  findFarmPart(adminId:number):Observable<Admin> {

    console.log("admin find FarmPartner service"+adminId);
    return this.http.get<Admin>(this.baseURL + "/getFarmPartById/" + adminId);
  }

  deleteFarmPart(adminId:number):Observable<string> {

    return  this.http.delete<string>(this.baseURL + `/deleteFarmPartById/${adminId}`);
  }
  */
  
}
