import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDriver } from './add-driver';
import { provideZonelessChangeDetection } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('AddDriver', () => {
  let component: AddDriver;
  let fixture: ComponentFixture<AddDriver>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddDriver,HttpClientTestingModule,
        RouterTestingModule.withRoutes([]) ],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddDriver);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
