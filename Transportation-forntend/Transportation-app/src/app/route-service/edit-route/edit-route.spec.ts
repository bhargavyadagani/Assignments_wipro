import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditRoute } from './edit-route';
import { provideZonelessChangeDetection } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';



describe('EditRoute', () => {
  let component: EditRoute;
  let fixture: ComponentFixture<EditRoute>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditRoute],
      providers:[provideZonelessChangeDetection(),provideHttpClient()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditRoute);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
