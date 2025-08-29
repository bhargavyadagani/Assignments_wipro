export interface Vehicle {
  vehicleId?: number;
  vehicleNumber: string;
  type: string;           // e.g., CAR, BUS
  capacity: number;
  status: 'AVAILABLE' | 'ON_TRIP' | 'MAINTENANCE';
  createdAt?: string;
  updatedAt?: string;
}

