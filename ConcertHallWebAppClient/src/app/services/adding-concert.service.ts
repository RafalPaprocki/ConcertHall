import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddingConcertService {

baseUrl = 'http://localhost:8889/event';

constructor(private http: HttpClient) { }

newConcert(model: any) {
  return this.http.post(this.baseUrl + '/add', model);
}

}
