import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConcertsListService } from '../services/concerts-list.service';
import { SeatsService } from '../services/seats.service';
import { TicketService } from '../services/ticket.service';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-buy-ticket',
  templateUrl: './buy-ticket.component.html',
  styleUrls: ['./buy-ticket.component.css']
})
export class BuyTicketComponent implements OnInit, OnDestroy {

  id: number;
  private sub: any;
  concerts: any = {};
  price: number;
  seats: any = {};
  seatId: number;
  model: any = {};

  private roles: string[];
  private authority: string;
  public isLoggedIn = false;
  constructor(private route: ActivatedRoute, private events: ConcertsListService, private tickett: TicketService,
    private token: TokenStorageService, private tokenStorage: TokenStorageService) {}

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
       this.id = +params['id'];
       this.price = +params['price'];
    });


    if (this.tokenStorage.getToken()) {
    this.isLoggedIn = true;
    this.roles = this.tokenStorage.getAuthorities();
    this.roles.every(role => {
      if (role === 'ROLE_ADMIN') {
        this.authority = 'admin';
        return false;
      } else if (role === 'ROLE_PM') {
        this.authority = 'pm';
        return false;
      }
      this.authority = 'user';
      return true;
    });
  }



    this.allSeats();

    console.log(this.seats);
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  allSeats() {
    this.events.getSeats().subscribe((data: any) => {
      this.seats = data;
  });
}

  buyTicket() {
    this.model.user_name = this.token.getUsername();
    this.model.event_id = this.id;
    this.model.seat_id = this.seatId;
    this.model.price = this.price;

    this.tickett.newTicket(this.model).subscribe();
  }
}
