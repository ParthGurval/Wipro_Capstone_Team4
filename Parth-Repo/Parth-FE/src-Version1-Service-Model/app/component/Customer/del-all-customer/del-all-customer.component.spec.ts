import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelAllCustomerComponent } from './del-all-customer.component';

describe('DelAllCustomerComponent', () => {
  let component: DelAllCustomerComponent;
  let fixture: ComponentFixture<DelAllCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DelAllCustomerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DelAllCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
