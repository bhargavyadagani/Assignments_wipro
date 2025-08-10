package com.example.movie_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.movie_service.dto.TheaterDto;

@FeignClient(name="theater-service", url="http://localhost:2424")
public interface MovieClient {

	@GetMapping("/api/{id}")
	 TheaterDto getTheaterById(@PathVariable Long id );
}
