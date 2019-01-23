import { Component, OnInit } from '@angular/core';
import { AddingConcertService } from '../services/adding-concert.service';

@Component({
  selector: 'app-add-concert',
  templateUrl: './add-concert.component.html',
  styleUrls: ['./add-concert.component.css']
})
export class AddConcertComponent implements OnInit {

  model: any = {};
  id: number;


  constructor(private addConcertService: AddingConcertService) { }

  ngOnInit() {
  }

  addConcert() {
    this.addConcertService.newConcert(this.model, this.id).subscribe(data => {
    });
  }

}
