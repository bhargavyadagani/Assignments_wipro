import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { RouteService } from '../route-service';
import { Route } from '../route';

@Component({
  selector: 'app-view-route',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './view-route.html',
  styleUrl: './view-route.css'
})
export class ViewRoute implements OnInit {
  routes: Route[] = [];
  message = '';
  isLoading = true;

  constructor(private routeService: RouteService, private router: Router, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadRoutes();
  }

  loadRoutes() {
    this.isLoading = true;
    this.routeService.getAllRoutes().subscribe({
      next: data => {
        console.log('Routes API:', data);
        this.routes = data || [];
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: err => {
        console.error(err);
        this.message = 'Failed to load routes!';
        this.isLoading = false;
      }
    });
  }

  deleteRoute(id?: number) {
    if (!id || !confirm('Are you sure to delete this route?')) return;
    this.routeService.deleteRoute(id).subscribe({
      next: () => this.loadRoutes(),
      error: err => {
        console.error(err);
        alert('Failed to delete route!');
      }
    });
  }

  editRoute(id?: number) {
    if (!id) return;
    this.router.navigate(['/edit-route', id]);
  }
}
