import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable({
  providedIn: 'root'
})
export class ConcertHallService {
  constructor(private http: HttpClient) {
  }
  sendPost(body:any): Observable<any>{
    return this.http.post('//localhost:8889/article/add', body);
  }

  getRooms(): Observable<any>{
    return this.http.get('//localhost:8889/room/all');
  }

  exportExcel() : Observable<any>{
    return this.http.get('//localhost:8889/download/customers.xlsx');
  }
}
