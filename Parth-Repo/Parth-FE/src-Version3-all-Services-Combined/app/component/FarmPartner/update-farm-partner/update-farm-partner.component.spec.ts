import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFarmPartnerComponent } from './update-farm-partner.component';

describe('UpdateFarmPartnerComponent', () => {
  let component: UpdateFarmPartnerComponent;
  let fixture: ComponentFixture<UpdateFarmPartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateFarmPartnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateFarmPartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
