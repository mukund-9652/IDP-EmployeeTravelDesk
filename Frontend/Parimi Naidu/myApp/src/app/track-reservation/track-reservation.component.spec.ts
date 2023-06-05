import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackReservationComponent } from './track-reservation.component';

describe('TrackReservationComponent', () => {
  let component: TrackReservationComponent;
  let fixture: ComponentFixture<TrackReservationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TrackReservationComponent]
    });
    fixture = TestBed.createComponent(TrackReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
