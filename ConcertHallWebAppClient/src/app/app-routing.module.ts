import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {ConcertHallMainViewComponent} from "./components/concert-hall-main-view/concert-hall-main-view.component";


const routes: Routes = [
  { path: '', redirectTo: 'concertHallMainViewComponent', pathMatch: 'full' },
  { path: 'concertHallMainViewComponent', component: ConcertHallMainViewComponent }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {
}
