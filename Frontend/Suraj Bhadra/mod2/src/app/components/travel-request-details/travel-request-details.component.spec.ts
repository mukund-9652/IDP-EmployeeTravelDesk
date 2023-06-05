import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelRequestDetailsComponent } from './travel-request-details.component';

describe('TravelRequestDetailsComponent', () => {
  let component: TravelRequestDetailsComponent;
  let fixture: ComponentFixture<TravelRequestDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TravelRequestDetailsComponent]
    });
    fixture = TestBed.createComponent(TravelRequestDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
