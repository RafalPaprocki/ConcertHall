/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { SeatsService } from './seats.service';

describe('Service: Seats', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SeatsService]
    });
  });

  it('should ...', inject([SeatsService], (service: SeatsService) => {
    expect(service).toBeTruthy();
  }));
});
