import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Driver } from '../driver';
import { ActivatedRoute, Router } from '@angular/router';
import { DriverService } from '../driver-service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-driver',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './edit-driver.html',
  styleUrls: ['./edit-driver.css']
})
export class EditDriver implements OnInit {
  driver: Driver = {
    driverId: 0,
    name: '',
    licenseNumber: '',
    phoneNumber: '',
    status: 'ACTIVE',
    createdAt: '',
    updatedAt: ''
  };

  driverId!: number;

  constructor(
    private route: ActivatedRoute,
    private driverService: DriverService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.driverId = Number(this.route.snapshot.params['id']); // get driverId from URL
    this.loadDriver();
  }

  loadDriver() {
    this.driverService.getDriverById(this.driverId).subscribe({
      next: (data) => {
        this.driver = data;
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Failed to load driver:', err)
    });
  }

  onSubmit() {
    this.driverService.updateDriver(this.driverId, this.driver).subscribe({
      next: () => {
        alert('Driver updated successfully!');
        this.router.navigate(['/drivers']); // navigate back to driver list
      },
      error: (err) => {
        console.error('Failed to update driver:', err);
        alert('Failed to update driver!');
      }
    });
  }
}
