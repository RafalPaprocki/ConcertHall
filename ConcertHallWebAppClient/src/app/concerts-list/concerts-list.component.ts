import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-concerts-list',
  templateUrl: './concerts-list.component.html',
  styleUrls: ['./concerts-list.component.css']
})
export class ConcertsListComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  buyTicket() {
    this.router.navigate(['/buy']);
  }

}
