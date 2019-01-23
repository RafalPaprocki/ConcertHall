import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ConcertHallService} from "../services/concert-hall.service";

@Component({
  selector: 'app-concerts-list',
  templateUrl: './concerts-list.component.html',
  styleUrls: ['./concerts-list.component.css']
})
export class ConcertsListComponent implements OnInit {

  constructor(private router: Router, private concertHallService: ConcertHallService) { }

  ngOnInit() {
  }

  exportToExcel(){
    this.concertHallService.exportExcel().subscribe(data => {
      console.log("poszło");
    });
  }

  buyTicket() {
    this.router.navigate(['/buy']);
  }

}
