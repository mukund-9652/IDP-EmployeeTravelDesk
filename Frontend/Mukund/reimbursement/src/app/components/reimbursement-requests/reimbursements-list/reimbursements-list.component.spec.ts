import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementsListComponent } from './reimbursements-list.component';

describe('ReimbursementsListComponent', () => {
  let component: ReimbursementsListComponent;
  let fixture: ComponentFixture<ReimbursementsListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReimbursementsListComponent]
    });
    fixture = TestBed.createComponent(ReimbursementsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
