package com.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class DoctorRepository {
	private Map<String, List<LocalDate>> schedule;

	public DoctorRepository() {
		schedule=new HashMap<String, List<LocalDate>>();
		schedule.put("DOC101", Arrays.asList(LocalDate.of(2025, 10, 23)));
		schedule.put("DOC102", Arrays.asList(LocalDate.of(2025, 10, 24)));
	}
	
	public boolean isDoctorAvailable(String docId,LocalDate date)
	{
		List<LocalDate> availableDates = schedule.get(docId);
        return availableDates != null && availableDates.contains(date);
	}
	
	
	
}
