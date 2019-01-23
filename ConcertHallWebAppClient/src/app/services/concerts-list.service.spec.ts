/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ConcertsListService } from './concerts-list.service';

describe('Service: ConcertsList', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConcertsListService]
    });
  });

  it('should ...', inject([ConcertsListService], (service: ConcertsListService) => {
    expect(service).toBeTruthy();
  }));
});
