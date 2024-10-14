import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelCustomerComponent } from './del-customer.component';

describe('DelCustomerComponent', () => {
  let component: DelCustomerComponent;
  let fixture: ComponentFixture<DelCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DelCustomerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DelCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
