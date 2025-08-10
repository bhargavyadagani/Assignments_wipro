package com.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TicketService {
	@Autowired
	private FlightService flightservice;

	public FlightService getFlightservice() {
		return flightservice;
	}

	public void setFlightservice(FlightService flightservice) {
		this.flightservice = flightservice;
	}
	
	public String conformBooking(String fligId, String userId)
	{
		if(flightservice.isSeatAvailable(fligId))
		{
			flightservice.bookSeats(fligId);
			return "Booking Confirmed" +userId+"On"+fligId;
		}
		else
		{
			return "Flight"+fligId+"Full";
		}
	}
}
