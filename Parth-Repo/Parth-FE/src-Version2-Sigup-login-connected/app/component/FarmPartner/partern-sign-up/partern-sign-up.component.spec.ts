import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParternSignUpComponent } from './partern-sign-up.component';

describe('ParternSignUpComponent', () => {
  let component: ParternSignUpComponent;
  let fixture: ComponentFixture<ParternSignUpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParternSignUpComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParternSignUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
