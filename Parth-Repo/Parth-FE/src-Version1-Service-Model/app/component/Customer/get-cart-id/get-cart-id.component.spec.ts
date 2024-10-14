import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetCartIdComponent } from './get-cart-id.component';

describe('GetCartIdComponent', () => {
  let component: GetCartIdComponent;
  let fixture: ComponentFixture<GetCartIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetCartIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetCartIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
