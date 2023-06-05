import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTravelRequestComponent } from './new-travel-request.component';

describe('NewTravelRequestComponent', () => {
  let component: NewTravelRequestComponent;
  let fixture: ComponentFixture<NewTravelRequestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewTravelRequestComponent]
    });
    fixture = TestBed.createComponent(NewTravelRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
