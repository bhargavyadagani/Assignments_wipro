export interface Booking {
  bookingId?: number;
  customerName: string;
  contactNumber: string;
  vehicleId: number;
  driverId: number;
  routeId: number;
  bookingStatus?: 'PENDING' | 'CONFIRMED' | 'COMPLETED' | 'CANCELLED';
  bookingTime?: string;
  startTime?: string;
  endTime?: string;
  createdAt?: string;
  updatedAt?: string;
}
