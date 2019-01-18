/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { AddingConcertService } from './adding-concert.service';

describe('Service: AddingConcert', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddingConcertService]
    });
  });

  it('should ...', inject([AddingConcertService], (service: AddingConcertService) => {
    expect(service).toBeTruthy();
  }));
});
