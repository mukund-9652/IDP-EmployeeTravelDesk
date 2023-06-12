import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementRequestTableComponent } from './reimbursement-request-table.component';

describe('ReimbursementRequestTableComponent', () => {
  let component: ReimbursementRequestTableComponent;
  let fixture: ComponentFixture<ReimbursementRequestTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReimbursementRequestTableComponent]
    });
    fixture = TestBed.createComponent(ReimbursementRequestTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
