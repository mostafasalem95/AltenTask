import { Injectable }    from '@angular/core';  
import { URLSearchParams } from '@angular/http'; 
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Customer } from '../models/customer'; 
import { VehicleStatus } from '../models/vehicleStatus';  
import { map, catchError } from 'rxjs/operators';
import {Observable} from 'rxjs/Observable'; 




@Injectable()  
export class VehicleService {  
  constructor(private http: HttpClient) { }  
  private vehicleUrl = 'http://localhost:8765/api/'  
  
  getAllCustomers(): Observable<Customer[]> {  
    const endPoint = 'vs/getAllCustomers';  
    return this.http.get<Customer[]>(this.vehicleUrl + endPoint);
  }  

  getVehicleStatus(vehicleId): Observable<VehicleStatus> {  
    const endPoint = 'vs/getVehicleStatus/'+vehicleId;
    return this.http.get<VehicleStatus>(this.vehicleUrl + endPoint);
  }  

}  