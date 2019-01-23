import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConcertsListService } from '../services/concerts-list.service';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-concerts-list',
  templateUrl: './concerts-list.component.html',
  styleUrls: ['./concerts-list.component.css']
})
export class ConcertsListComponent implements OnInit {

  constructor(private router: Router, private events: ConcertsListService, private token: TokenStorageService,
    private tokenStorage: TokenStorageService) { }
  concerts: any = {};
  private roles: string[];
  private authority: string;
  public isLoggedIn = false;
  ngOnInit() {
    this.allConcerts();



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
  }

  buyTicket() {
    this.router.navigate(['/buy']);
  }

  allConcerts() {
    this.events.getConcerts().subscribe((data: any) => {
      this.concerts = data;
  });
}

  isAdmin() {
    return this.authority === 'admin';
  }

  deleteEvent() {
    
  }
}
