import { Component, OnInit } from '@angular/core';
import {ConcertHallService} from "../../services/concert-hall.service";

@Component({
  selector: 'app-concert-hall-main-view',
  templateUrl: './concert-hall-main-view.component.html',
  styleUrls: ['./concert-hall-main-view.component.css']
})
export class ConcertHallMainViewComponent implements OnInit {

  rooms

  constructor(private concertHallService: ConcertHallService) { }

  ngOnInit() {
    debugger
    this.concertHallService.getRooms().subscribe(data => {
      this.rooms = data.content;
      console.log(this.rooms)
    });
  }
}
