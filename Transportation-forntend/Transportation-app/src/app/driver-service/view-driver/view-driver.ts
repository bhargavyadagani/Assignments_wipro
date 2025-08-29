import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { DriverService } from '../driver-service';
import { Driver } from '../driver';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-driver',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './view-driver.html',
  styleUrl:'./view-driver.css'
})
export class ViewDriver implements OnInit {

  drivers: Driver[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(private driverService: DriverService, private cdr: ChangeDetectorRef, private router: Router) {}

  ngOnInit(): void {
    this.loadDrivers();
  }

  loadDrivers() {
    console.log("Loading drivers...");
    this.isLoading = true;

    this.driverService.getAllDrivers().subscribe({
      next: (data) => {
        console.log("API Response: ", data, Array.isArray(data));

        this.drivers = [];
        if (Array.isArray(data)) {
          data.forEach(driver => this.drivers.push(driver));
          this.cdr.detectChanges();
        }

        console.log("Assigned drivers length:", this.drivers.length);
        this.isLoading = false;
      },
      error: (err) => {
        this.errorMessage = 'Failed to fetch drivers!';
        console.error(err);
        this.isLoading = false;
      }
    });
  }

  deleteDriver(id: number | undefined) {
    if (!id) return;
    if (confirm('Are you sure you want to delete this driver?')) {
      this.driverService.deleteDriver(id).subscribe({
        next: () => {
          alert('Driver deleted successfully!');
          this.loadDrivers();  // reload list after delete
        },
        error: (err) => {
          console.error(err);
          alert('Failed to delete driver!');
        }
      });
    }
  }

  editDriver(id: number | undefined) {
    if (!id) return;
    this.router.navigate(['/edit-driver', id]);
  }
}
