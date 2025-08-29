import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRoute } from './view-route';
import { provideZonelessChangeDetection } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';
import { ActivatedRoute, provideRouter } from '@angular/router';


describe('ViewRoute', () => {
  let component: ViewRoute;
  let fixture: ComponentFixture<ViewRoute>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewRoute],
      providers: [provideZonelessChangeDetection(), provideHttpClient(),
        provideRouter([]), // ✅ provide empty router
        {
          provide: ActivatedRoute,
        }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewRoute);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
