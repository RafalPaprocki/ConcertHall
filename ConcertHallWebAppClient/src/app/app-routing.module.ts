import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {ConcertHallMainViewComponent} from "./components/concert-hall-main-view/concert-hall-main-view.component";
import {LoginComponent} from "./login/login.component";
import {HomeComponent} from "./home/home.component";
import {UserComponent} from "./user/user.component";
import {RegisterComponent} from "./register/register.component";


const routes: Routes = [
  {
    path: '',
    redirectTo: 'concertHallMainViewComponent',
    pathMatch: 'full' },
  {
    path: 'concertHallMainViewComponent',
    component: ConcertHallMainViewComponent },
  {
    path: 'auth/login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'signup',
    component: RegisterComponent
  },
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {
}
