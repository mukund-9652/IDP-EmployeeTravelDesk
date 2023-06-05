import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeGradeComponent } from './change-grade.component';

describe('ChangeGradeComponent', () => {
  let component: ChangeGradeComponent;
  let fixture: ComponentFixture<ChangeGradeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ChangeGradeComponent]
    });
    fixture = TestBed.createComponent(ChangeGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
