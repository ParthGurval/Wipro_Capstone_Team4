import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPartIdComponent } from './get-part-id.component';

describe('GetPartIdComponent', () => {
  let component: GetPartIdComponent;
  let fixture: ComponentFixture<GetPartIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetPartIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetPartIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
