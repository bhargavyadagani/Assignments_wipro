export interface Driver {
  driverId?: number;            
  name: string;
  licenseNumber: string;
  phoneNumber: string;
  status: 'ACTIVE' | 'INACTIVE';
  createdAt?: string;
  updatedAt?: string;
}
