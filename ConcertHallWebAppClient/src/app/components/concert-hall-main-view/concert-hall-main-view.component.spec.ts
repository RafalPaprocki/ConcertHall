import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConcertHallMainViewComponent } from './concert-hall-main-view.component';

describe('ConcertHallMainViewComponent', () => {
  let component: ConcertHallMainViewComponent;
  let fixture: ComponentFixture<ConcertHallMainViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConcertHallMainViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConcertHallMainViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
