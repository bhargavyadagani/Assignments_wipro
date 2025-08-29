import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDriver } from './view-driver';
import { provideZonelessChangeDetection } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';


describe('ViewDriver', () => {
  let component: ViewDriver;
  let fixture: ComponentFixture<ViewDriver>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewDriver],providers: [provideZonelessChangeDetection(), provideHttpClient()]
      
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewDriver);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
