import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewVehicle } from './view-vehicle';
import { provideZonelessChangeDetection } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';


describe('ViewVehicle', () => {
  let component: ViewVehicle;
  let fixture: ComponentFixture<ViewVehicle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewVehicle ],
      providers: [provideZonelessChangeDetection(), provideHttpClient()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewVehicle);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
