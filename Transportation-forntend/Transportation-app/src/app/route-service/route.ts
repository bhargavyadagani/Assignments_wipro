export interface Route {
  routeId?: number;
  source: string;
  destination: string;
  distance: number;
  estimatedTime: string | null;
  createdAt?: string;
  updatedAt?: string;
}

