import { TestBed } from '@angular/core/testing';

import { ReimbursementTypesService } from './reimbursement-types.service';

describe('ReimbursementTypesService', () => {
  let service: ReimbursementTypesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReimbursementTypesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
