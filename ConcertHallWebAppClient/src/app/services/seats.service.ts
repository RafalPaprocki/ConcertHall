import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SeatsService {

  baseUrl = 'http://localhost:8889/seat/all';

  constructor(private http: HttpClient) { }

  getSeats() {
    return this.http.get(this.baseUrl);
  }
}
