/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AddConcertComponent } from './add-concert.component';

describe('AddConcertComponent', () => {
  let component: AddConcertComponent;
  let fixture: ComponentFixture<AddConcertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddConcertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddConcertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
