package com.booking;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class FlightService {
	private Map<String, Integer> flight;
	
	public FlightService()
	{
		flight=new HashMap<>();
		
		flight.put("FL123", 4);
		flight.put("FL345", 1);
	}
	
	public boolean isSeatAvailable(String fligId)
	{
		Integer seats=flight.get(fligId);
		return seats!=null && seats>0;
	}
	public void bookSeats(String fligId)
	{
		if(isSeatAvailable(fligId))
		{
			flight.put(fligId, flight.get(fligId)-1);
		}
	}
}
