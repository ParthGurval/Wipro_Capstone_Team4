import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllFarmPartnerComponent } from './get-all-farm-partner.component';

describe('GetAllFarmPartnerComponent', () => {
  let component: GetAllFarmPartnerComponent;
  let fixture: ComponentFixture<GetAllFarmPartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllFarmPartnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllFarmPartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
