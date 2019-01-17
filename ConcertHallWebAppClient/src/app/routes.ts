import { Routes } from '@angular/router';
import { AddConcertComponent } from './add-concert/add-concert.component';
import { ConcertsListComponent } from './concerts-list/concerts-list.component';
import { BuyTicketComponent } from './buy-ticket/buy-ticket.component';


export const appRoutes: Routes = [
    { path: 'adding', component : AddConcertComponent},
    { path: 'concerts', component : ConcertsListComponent},
    { path: 'buy', component : BuyTicketComponent},

    // has to be last
    { path: '**', redirectTo: 'concerthallmainview', pathMatch: 'full'}
];
