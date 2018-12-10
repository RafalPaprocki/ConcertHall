import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import {BsModalService, ModalModule} from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { AccordionModule } from 'ngx-bootstrap/accordion'
import {ComponentLoaderFactory, PositioningService} from "ngx-bootstrap";
import { ConcertHallMainViewComponent } from './components/concert-hall-main-view/concert-hall-main-view.component';

@NgModule({
  declarations: [
    AppComponent,
    ConcertHallMainViewComponent,
  ],
  imports: [
    BrowserModule,
     HttpClientModule,
     AppRoutingModule,
     FormsModule,
    AccordionModule.forRoot(),
    ModalModule.forRoot()
  ],
  providers: [
    BsModalService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
