import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadReservationComponent } from './reservation-upload.component';

describe('ReservationUploadComponent', () => {
  let component: UploadReservationComponent;
  let fixture: ComponentFixture<UploadReservationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UploadReservationComponent]
    });
    fixture = TestBed.createComponent(UploadReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
