import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelPartnerComponent } from './del-partner.component';

describe('DelPartnerComponent', () => {
  let component: DelPartnerComponent;
  let fixture: ComponentFixture<DelPartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DelPartnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DelPartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
