import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementRequestFormComponent } from './reimbursement-request-form.component';

describe('ReimbursementRequestFormComponent', () => {
  let component: ReimbursementRequestFormComponent;
  let fixture: ComponentFixture<ReimbursementRequestFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReimbursementRequestFormComponent]
    });
    fixture = TestBed.createComponent(ReimbursementRequestFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
