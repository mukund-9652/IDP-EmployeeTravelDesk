import { TestBed } from '@angular/core/testing';

import { ReimbursementRequestsService } from './reimbursement-requests.service';

describe('ReimbursementRequestsService', () => {
  let service: ReimbursementRequestsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReimbursementRequestsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
