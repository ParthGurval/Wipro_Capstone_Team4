import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetProductIdComponent } from './get-product-id.component';

describe('GetProductIdComponent', () => {
  let component: GetProductIdComponent;
  let fixture: ComponentFixture<GetProductIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetProductIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetProductIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
