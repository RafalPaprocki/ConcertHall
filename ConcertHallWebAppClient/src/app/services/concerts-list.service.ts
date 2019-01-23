import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConcertsListService {

  baseUrl = 'http://localhost:8889/event/all';

  constructor(private http: HttpClient) { }

  getConcerts() {
    return this.http.get(this.baseUrl);
  }

  getSeats() {
    return this.http.get('http://localhost:8889/seat/all');
  }
}
