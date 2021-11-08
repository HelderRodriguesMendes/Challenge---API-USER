package com.testePratico.API_User.service;

import com.testePratico.API_User.model.Location;
import com.testePratico.API_User.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CoordinatesService coordinatesService;

    @Autowired
    private TimezoneService timezoneService;

    @Autowired
    private StreetService streetService;

    public Location save(Location location){
        if(location.getStreet() != null){
            location.setStreet(streetService.save(location.getStreet()));
        }

        if(location.getCoordinates() != null){
            location.setCoordinates(coordinatesService.save(location.getCoordinates()));
        }

        if(location.getTimezone() != null){
            location.setTimezone(timezoneService.save(location.getTimezone()));
        }
        return locationRepository.save(location);
    }
}
