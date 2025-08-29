import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { BookingService } from '../booking-service';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Booking } from '../booking';

@Component({
  selector: 'app-view-booking',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './view-booking.html',
  styleUrl :'./view-booking.css',
})
export class ViewBooking implements OnInit {
  bookings: Booking[] = [];
  message = '';
  isLoading = true;

  constructor(private bookingService: BookingService, private router: Router, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadBookings();
  }

  loadBookings() {
    this.bookingService.getAllBookings().subscribe({
      next: data => {
        this.bookings = data;
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: err => {
        console.error(err);
        this.message = 'Failed to load bookings!';
        this.isLoading = false;
      }
    });
  }

  deleteBooking(id?: number) {
    if (!id) return;
    if (!confirm('Are you sure to delete this booking?')) return;
    this.bookingService.deleteBooking(id).subscribe({
      next: () => this.loadBookings(),
      error: err => {
        console.error(err);
        alert('Failed to delete booking!');
      }
    });
  }

  editBooking(id?: number) {
    if (!id) return;
    this.router.navigate(['/edit-booking', id]);
  }
}
