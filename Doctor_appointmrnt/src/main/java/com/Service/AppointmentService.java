package com.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.Repository.DoctorRepository;

public class AppointmentService {
	@Autowired
	private DoctorRepository doctorrepository;
	
	public void setDoctorRepository(DoctorRepository doctorrepository)
	{
		this.doctorrepository=doctorrepository;
	}
	
	public String Book(String docId, String date)
	{
		LocalDate date1=LocalDate.parse(date);
		boolean available=doctorrepository.isDoctorAvailable(docId, date1);
		if(available)
		{
			return "Appointment Available";
		}
		else
		{
			return "Not Available";
		}
	}
}
