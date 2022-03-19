package com.tripmanagement.asdc.service;

import java.util.List;

import com.tripmanagement.asdc.model.Location;

public interface LocationService {

	public boolean addLocation(Location location);
	public List<String> getSources();
	public List<String> getDestinations();
	
}