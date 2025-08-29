import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { RouteService } from '../route-service';
import { Route } from '../route';

@Component({
  selector: 'app-edit-route',
  standalone: true,
  imports: [CommonModule, FormsModule,RouterModule],
  templateUrl: './edit-route.html',
  styleUrl: './edit-route.css'
})
export class EditRoute implements OnInit {
  routeId!: number;
  route: Route = { source: '', destination: '', distance: 0, estimatedTime: ''};
  message = '';

  constructor(private routeService: RouteService, private router: Router, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.routeId = Number(this.activatedRoute.snapshot.paramMap.get('id'));
    this.routeService.getRouteById(this.routeId).subscribe({
      next: data => this.route = data,
      error: err => {
        console.error(err);
        this.message = 'Failed to load route!';
      }
    });
  }

  onSubmit() {
    this.routeService.updateRoute(this.routeId, this.route).subscribe({
      next: () => {
        alert('Route updated successfully!');
        this.router.navigate(['/routes']);
      },
      error: err => {
        console.error(err);
        this.message = 'Failed to update route!';
      }
    });
  }
}
