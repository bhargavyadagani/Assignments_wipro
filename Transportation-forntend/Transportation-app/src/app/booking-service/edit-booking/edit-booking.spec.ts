import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditBooking } from './edit-booking';
import { provideZonelessChangeDetection } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';

describe('EditBooking', () => {
  let component: EditBooking;
  let fixture: ComponentFixture<EditBooking>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditBooking],
      providers: [provideZonelessChangeDetection(), provideHttpClient()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditBooking);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
