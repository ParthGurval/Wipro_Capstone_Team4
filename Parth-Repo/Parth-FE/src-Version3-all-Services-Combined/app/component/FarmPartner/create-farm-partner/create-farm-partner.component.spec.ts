import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFarmPartnerComponent } from './create-farm-partner.component';

describe('CreateFarmPartnerComponent', () => {
  let component: CreateFarmPartnerComponent;
  let fixture: ComponentFixture<CreateFarmPartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateFarmPartnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateFarmPartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
