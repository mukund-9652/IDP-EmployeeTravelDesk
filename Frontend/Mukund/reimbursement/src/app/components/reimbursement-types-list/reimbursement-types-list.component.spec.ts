import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementTypesListComponent } from './reimbursement-types-list.component';

describe('ReimbursementTypesListComponent', () => {
  let component: ReimbursementTypesListComponent;
  let fixture: ComponentFixture<ReimbursementTypesListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReimbursementTypesListComponent]
    });
    fixture = TestBed.createComponent(ReimbursementTypesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
