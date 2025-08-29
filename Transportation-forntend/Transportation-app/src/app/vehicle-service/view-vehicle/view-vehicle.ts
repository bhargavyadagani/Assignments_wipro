import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { VehicleService } from '../vehicle-service';
import { Vehicle } from '../vehicle';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-vehicle',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './view-vehicle.html',
  styleUrls: ['./view-vehicle.css']
})
export class ViewVehicle implements OnInit {
  vehicles: Vehicle[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(
    private vehicleService: VehicleService,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadVehicles();
  }

  loadVehicles() {
    this.isLoading = true;
    this.vehicleService.getAllVehicles().subscribe({
      next: (data) => {
        this.vehicles = Array.isArray(data) ? data : [];
        this.cdr.detectChanges();
        this.isLoading = false;
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Failed to load vehicles!';
        this.isLoading = false;
      }
    });
  }

  deleteVehicle(id?: number) {
    if (!id) return;
    if (confirm('Are you sure you want to delete this vehicle?')) {
      this.vehicleService.deleteVehicle(id).subscribe({
        next: () => this.loadVehicles(),
        error: (err) => {
          console.error(err);
          alert('Failed to delete vehicle!');
        }
      });
    }
  }

  editVehicle(id?: number) {
    if (!id) return;
    this.router.navigate(['/edit-vehicle', id]);
  }

  // 👇 Add this so Angular template can call it
  formatStatus(status: string): string {
    switch (status) {
      case 'AVAILABLE': return 'Available';
      case 'ON_TRIP': return 'On Trip';
      case 'MAINTENANCE': return 'Maintenance';
      default: return status;
    }
  }
}
