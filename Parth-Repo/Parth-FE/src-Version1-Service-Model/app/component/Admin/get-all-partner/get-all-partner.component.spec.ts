import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllPartnerComponent } from './get-all-partner.component';

describe('GetAllPartnerComponent', () => {
  let component: GetAllPartnerComponent;
  let fixture: ComponentFixture<GetAllPartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllPartnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllPartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
