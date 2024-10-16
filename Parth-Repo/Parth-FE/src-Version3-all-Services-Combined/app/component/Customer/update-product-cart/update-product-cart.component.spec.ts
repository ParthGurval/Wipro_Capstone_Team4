import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProductCartComponent } from './update-product-cart.component';

describe('UpdateProductCartComponent', () => {
  let component: UpdateProductCartComponent;
  let fixture: ComponentFixture<UpdateProductCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateProductCartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateProductCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
