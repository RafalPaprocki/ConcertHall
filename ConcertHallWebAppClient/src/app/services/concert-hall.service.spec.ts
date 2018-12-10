import { TestBed } from '@angular/core/testing';

import { ConcertHallService } from './concert-hall.service';

describe('ConcertHallService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ConcertHallService = TestBed.get(ConcertHallService);
    expect(service).toBeTruthy();
  });
});
