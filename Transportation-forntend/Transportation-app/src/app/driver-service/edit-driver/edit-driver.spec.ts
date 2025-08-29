import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDriver } from './edit-driver';
import { provideZonelessChangeDetection } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('EditDriver', () => {
  let component: EditDriver;
  let fixture: ComponentFixture<EditDriver>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditDriver,HttpClientTestingModule,
        RouterTestingModule.withRoutes([]) ],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditDriver);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
