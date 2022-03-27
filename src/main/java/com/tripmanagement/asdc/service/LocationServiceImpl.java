package com.tripmanagement.asdc.service;

import java.util.List;

import com.tripmanagement.asdc.dao.LocationDAO;
import com.tripmanagement.asdc.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationDAO locationDAO;
	
	@Override
	@Transactional
	public boolean addLocation(Location location) {
		boolean checkSource=false,checkDest=false;
		List<String> sources=locationDAO.getSources();
		for(String current_loc:sources)
		{
			if(current_loc==location.getCurrent_location())
				checkSource=true;

		}
		List<String> dest=locationDAO.getDestinations();
		for(String destination:dest)
		{
			if(destination==location.getDestination())
				checkDest=true;

		}
		if(checkSource&&checkDest)
			return false;
		return locationDAO.addLocation(location);
	}

	@Override
	@Transactional
	public List<String> getSources() {
		return locationDAO.getSources();
	}

	@Override
	@Transactional
	public List<String> getDestinations() {
		return locationDAO.getDestinations();
	}

	

}





