package com.tripmanagement.asdc.dao;

import java.util.List;

import com.tripmanagement.asdc.model.Location;

public interface LocationDAO {

	public boolean addLocation(Location location);
	public List<String> getSources();
	public List<String> getDestinations();
	
}