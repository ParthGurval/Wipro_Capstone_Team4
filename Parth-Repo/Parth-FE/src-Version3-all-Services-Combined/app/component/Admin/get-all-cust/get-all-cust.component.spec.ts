import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllCustComponent } from './get-all-cust.component';

describe('GetAllCustComponent', () => {
  let component: GetAllCustComponent;
  let fixture: ComponentFixture<GetAllCustComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllCustComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllCustComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
