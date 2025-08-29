import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBooking } from './add-booking';
import { provideZonelessChangeDetection } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';

describe('AddBooking', () => {
  let component: AddBooking;
  let fixture: ComponentFixture<AddBooking>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddBooking],
      providers: [provideZonelessChangeDetection(), provideHttpClient()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddBooking);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
