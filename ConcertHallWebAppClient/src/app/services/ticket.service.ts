import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  baseUrl = 'http://localhost:8889';

  constructor(private http: HttpClient) { }

  newTicket(model: any) {
    return this.http.post(this.baseUrl + '/ticket', model);
  }
}
