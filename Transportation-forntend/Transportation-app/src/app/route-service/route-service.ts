import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Route } from './route';

@Injectable({
  providedIn: 'root'
})
export class RouteService {
  private baseUrl = 'http://localhost:1001/api/routes';

  constructor(private http: HttpClient) {}

  getAllRoutes(): Observable<Route[]> {
    return this.http.get<Route[]>(this.baseUrl);
  }

  getRouteById(id: number): Observable<Route> {
    return this.http.get<Route>(`${this.baseUrl}/${id}`);
  }

  createRoute(route: Route): Observable<Route> {
    return this.http.post<Route>(this.baseUrl, route);
  }

  updateRoute(id: number, route: Route): Observable<Route> {
    return this.http.put<Route>(`${this.baseUrl}/${id}`, route);
  }

  deleteRoute(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
