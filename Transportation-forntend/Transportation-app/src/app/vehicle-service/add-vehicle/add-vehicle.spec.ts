import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddVehicle } from './add-vehicle';
import { provideZonelessChangeDetection } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';


describe('AddVehicle', () => {
  let component: AddVehicle;
  let fixture: ComponentFixture<AddVehicle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddVehicle],providers: [provideZonelessChangeDetection(), provideHttpClient()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddVehicle);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
