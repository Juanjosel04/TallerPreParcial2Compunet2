package edu.co.icesi.examjpatemplate.Controller;

import edu.co.icesi.examjpatemplate.entity.*;
import edu.co.icesi.examjpatemplate.Repository.*;

import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/api")
public class BusController {

    private final BusRepository busRepository;
    private final GeoPointRepository geoPointRepository;

    public BusController(BusRepository busRepository,GeoPointRepository geoPointRepository){
        this.busRepository = busRepository;
        this.geoPointRepository = geoPointRepository;

    }

    @GetMapping("/buses/by-route/{routeName}")
    public List<Bus> getBusesByRoute(@PathVariable String routeName) {
        return busRepository.findByRouteRouteName(routeName);
    }
    
    //ultima ubicacion de un buss
    @GetMapping("/buses/{plate}/last-location")
    public GeoPoint getLastLocation(@PathVariable String plate) {
        return geoPointRepository.findTopByBusLicensePlateOrderByTimestampDesc(plate);
    }
    
    @GetMapping("/buses/{plate}/geoPoints")
    public List<GeoPoint> getGeoPoints(@PathVariable String plate) {
        return geoPointRepository.findByBusLicensePlateOrderByTimestampAsc(plate);
    }
    
    
}
