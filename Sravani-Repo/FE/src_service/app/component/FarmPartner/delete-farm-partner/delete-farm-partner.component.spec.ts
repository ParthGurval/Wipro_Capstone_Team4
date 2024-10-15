import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteFarmPartnerComponent } from './delete-farm-partner.component';

describe('DeleteFarmPartnerComponent', () => {
  let component: DeleteFarmPartnerComponent;
  let fixture: ComponentFixture<DeleteFarmPartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteFarmPartnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteFarmPartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
