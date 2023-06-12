import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceNotFoundComponent } from './resource-not-found.component';

describe('ResourceNotFoundComponent', () => {
  let component: ResourceNotFoundComponent;
  let fixture: ComponentFixture<ResourceNotFoundComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResourceNotFoundComponent]
    });
    fixture = TestBed.createComponent(ResourceNotFoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
