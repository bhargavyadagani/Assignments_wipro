import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Booking } from '../booking';
import { BookingService } from '../booking-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-booking',
  standalone: true,
  imports: [FormsModule, RouterModule],
  templateUrl: './add-booking.html',
  styleUrl: './add-booking.css'
})
export class AddBooking {
  booking: Booking = {
    customerName: '',
    contactNumber: '',
    vehicleId: 0,
    driverId: 0,
    routeId: 0,
    bookingStatus: 'PENDING'
  };

  message = '';

  constructor(private bookingService: BookingService, private router: Router) {}

  onSubmit() {
    this.bookingService.createBooking({
      customerName: this.booking.customerName,
      contactNumber: this.booking.contactNumber,
      vehicleId: this.booking.vehicleId,
      driverId: this.booking.driverId,
      routeId: this.booking.routeId,
      bookingStatus: this.booking.bookingStatus
    }).subscribe({
      next: res => {
        alert('Booking added successfully!');
        this.router.navigate(['/bookings']); // redirect to view bookings
      },
      error: err => {
        console.error(err);
        alert('Failed to add booking!');
      }
    });
  }
}
