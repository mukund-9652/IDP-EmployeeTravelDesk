import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRequestListComponent } from './new-request-list.component';

describe('NewRequestListComponent', () => {
  let component: NewRequestListComponent;
  let fixture: ComponentFixture<NewRequestListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewRequestListComponent]
    });
    fixture = TestBed.createComponent(NewRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
