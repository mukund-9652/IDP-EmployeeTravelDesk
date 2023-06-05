import { TestBed } from '@angular/core/testing';

import { ReservationTypesService } from './reservation-types.service';

describe('ReservationTypesService', () => {
  let service: ReservationTypesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReservationTypesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
