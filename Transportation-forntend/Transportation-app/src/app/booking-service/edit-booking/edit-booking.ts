import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { BookingService } from '../booking-service';
import { Booking } from '../booking';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-booking',
  standalone: true,
  imports: [CommonModule, FormsModule,RouterModule],
  templateUrl: './edit-booking.html',
  styleUrl: './edit-booking.css'
})
export class EditBooking implements OnInit {
  booking: Booking = {
    customerName: '',
    contactNumber: '',
    vehicleId: 0,
    driverId: 0,
    routeId: 0,
    bookingStatus: 'PENDING'
  };

  id!: number;

  constructor(
    private route: ActivatedRoute,
    private bookingService: BookingService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.loadBooking();
  }

  loadBooking() {
    this.bookingService.getBookingById(this.id).subscribe({
      next: data => {
        this.booking = data;
        this.cdr.detectChanges();
      },
      error: err => console.error(err)
    });
  }

  onSubmit() {
    this.bookingService.updateBooking(this.id, this.booking).subscribe({
      next: () => {
        alert('Booking updated successfully!');
        this.router.navigate(['/bookings']);
      },
      error: err => {
        console.error(err);
        alert('Failed to update booking!');
      }
    });
  }
}

