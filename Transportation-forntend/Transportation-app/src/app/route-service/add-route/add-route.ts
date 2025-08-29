import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { RouteService } from '../route-service';
import { Route } from '../route';

@Component({
  selector: 'app-add-route',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './add-route.html',
  styleUrl: './add-route.css'
})
export class AddRoute {
  route: Route = {
    source: '',
    destination: '',
    distance: 0,
    estimatedTime: ''
  };
  message = '';

  constructor(private routeService: RouteService, private router: Router) {}

  onSubmit() {
  if (!this.route.source || !this.route.destination || !this.route.distance) {
    this.message = 'Please fill all required fields';
    return;
  }

  this.routeService.createRoute(this.route).subscribe({
    next: data => {
      alert('Route added successfully!');
      this.router.navigate(['/routes']);
    },
    error: err => {
      console.error('Add Route Error:', err);
      this.message = 'Failed to add route!';
    }
  });
}

}
