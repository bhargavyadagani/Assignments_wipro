import { Component, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { VehicleService } from '../vehicle-service';
import { Vehicle } from '../vehicle';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-add-vehicle',
  standalone: true,
  imports: [CommonModule, FormsModule,RouterModule],
  templateUrl: './add-vehicle.html',
  styleUrl: './add-vehicle.css'
})
export class AddVehicle {
  vehicle: Vehicle = {type: '', vehicleNumber: '', capacity: 0, status: 'AVAILABLE' };
  message = '';

  constructor(private vehicleService: VehicleService, private router: Router, private cdr: ChangeDetectorRef) {}

  onSubmit() {
    this.vehicleService.createVehicle(this.vehicle).subscribe({
      next: (data) => {
        alert('Vehicle added successfully!');
        this.router.navigate(['/vehicles']);
      },
      error: (err) => {
        console.error(err);
        this.message = 'Failed to add vehicle!';
      }
    });
  }
}
