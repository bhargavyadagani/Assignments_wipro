import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Driver } from './driver';


@Injectable({
  providedIn: 'root'
})
export class DriverService {
  private baseUrl = 'http://localhost:1002/api/drivers';

  constructor(private http: HttpClient) {}
  
  getAllDrivers(): Observable<Driver[]> {
    return this.http.get<Driver[]>(this.baseUrl);
  }

  getDriverById(id: number): Observable<Driver> {
    return this.http.get<Driver>(`${this.baseUrl}/${id}`);
  }

  createDriver(driver: Driver): Observable<Driver> {
    return this.http.post<Driver>(this.baseUrl, driver);
  }

  updateDriver(id: number, driver: Driver): Observable<Driver> {
    return this.http.put<Driver>(`${this.baseUrl}/${id}`, driver);
  }

  deleteDriver(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
