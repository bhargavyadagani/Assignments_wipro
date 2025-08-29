import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { VehicleService } from '../vehicle-service';
import { Vehicle } from '../vehicle';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-vehicle',
  standalone: true,
  imports: [FormsModule,RouterModule],
  templateUrl: './edit-vehicle.html',
  styleUrl: './edit-vehicle.css'
})
export class EditVehicle implements OnInit {
  vehicle: Vehicle = { type: '', vehicleNumber: '', capacity: 0, status: 'AVAILABLE' };
  vehicleId!: number;
  message: string = ''; 

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService, private router: Router, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.vehicleId = Number(this.route.snapshot.paramMap.get('id'));
    this.vehicleService.getVehicleById(this.vehicleId).subscribe({
      next: (data) => {
        this.vehicle = data;
        this.cdr.detectChanges();
      },
      error: (err) => console.error(err)
    });
  }

  onSubmit() {
    this.vehicleService.updateVehicle(this.vehicleId, this.vehicle).subscribe({
      next: () => {
        alert('Vehicle updated successfully!');
        this.router.navigate(['/vehicles']);
      },
      error: (err) => {
        console.error(err);
        alert('Failed to update vehicle!');
      }
    });
  }
}
