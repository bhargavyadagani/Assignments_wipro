import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditVehicle } from './edit-vehicle';
import { provideZonelessChangeDetection } from '@angular/core';


describe('EditVehicle', () => {
  let component: EditVehicle;
  let fixture: ComponentFixture<EditVehicle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditVehicle],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditVehicle);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
