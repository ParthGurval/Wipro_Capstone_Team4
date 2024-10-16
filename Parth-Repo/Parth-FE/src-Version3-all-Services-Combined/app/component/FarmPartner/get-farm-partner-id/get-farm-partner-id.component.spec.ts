import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetFarmPartnerIdComponent } from './get-farm-partner-id.component';

describe('GetFarmPartnerIdComponent', () => {
  let component: GetFarmPartnerIdComponent;
  let fixture: ComponentFixture<GetFarmPartnerIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetFarmPartnerIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetFarmPartnerIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
