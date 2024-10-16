import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteProductCartComponent } from './delete-product-cart.component';

describe('DeleteProductCartComponent', () => {
  let component: DeleteProductCartComponent;
  let fixture: ComponentFixture<DeleteProductCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteProductCartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteProductCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
