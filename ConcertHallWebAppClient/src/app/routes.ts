import { Routes } from '@angular/router';
import { AddConcertComponent } from './add-concert/add-concert.component';
import { ConcertsListComponent } from './concerts-list/concerts-list.component';
import { BuyTicketComponent } from './buy-ticket/buy-ticket.component';
import { ConcertHallMainViewComponent } from './components/concert-hall-main-view/concert-hall-main-view.component';


export const appRoutes: Routes = [
    { path: 'adding', component : AddConcertComponent},
    { path: 'concertHallMainViewComponent', component: ConcertHallMainViewComponent},
    { path: 'concerts', component : ConcertsListComponent},
    { path: 'buy/:id/:price', component : BuyTicketComponent},

    // has to be last
    { path: '**', redirectTo: 'concertHallMainViewComponent', pathMatch: 'full'}
];
