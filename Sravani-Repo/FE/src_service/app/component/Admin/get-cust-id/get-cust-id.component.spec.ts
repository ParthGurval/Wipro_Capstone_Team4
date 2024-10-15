import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetCustIdComponent } from './get-cust-id.component';

describe('GetCustIdComponent', () => {
  let component: GetCustIdComponent;
  let fixture: ComponentFixture<GetCustIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetCustIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetCustIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
