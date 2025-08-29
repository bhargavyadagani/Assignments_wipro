import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { DriverService } from '../driver-service';
import { Driver } from '../driver';

@Component({
  selector: 'app-add-driver',
  standalone: true,
  templateUrl: './add-driver.html',
  styleUrl:'./add-driver.css',
  imports: [CommonModule, FormsModule, RouterModule]
})
export class AddDriver {
  driver: Driver = {
    name: '',
    licenseNumber: '',
    phoneNumber: '',
    status: 'ACTIVE'
  };
  message: string = '';

  constructor(private driverService: DriverService, private router: Router) {}

  onSubmit() {
    this.driverService.createDriver(this.driver).subscribe({
      next: () => {
        this.message = 'Driver added successfully!';
        this.router.navigate(['/drivers']);
      },
      error: err => {
        console.error(err);
        this.message = 'Failed to add driver!';
      }
    });
  }
}
