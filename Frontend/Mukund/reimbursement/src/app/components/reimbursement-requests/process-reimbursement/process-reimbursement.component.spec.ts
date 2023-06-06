import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessReimbursementComponent } from './process-reimbursement.component';

describe('ProcessReimbursementComponent', () => {
  let component: ProcessReimbursementComponent;
  let fixture: ComponentFixture<ProcessReimbursementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProcessReimbursementComponent]
    });
    fixture = TestBed.createComponent(ProcessReimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
