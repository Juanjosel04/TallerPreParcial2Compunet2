package edu.co.icesi.examjpatemplate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.co.icesi.examjpatemplate.entity.GeoPoint;

@Repository
public interface GeoPointRepository extends JpaRepository<GeoPoint,Integer>{

    List<GeoPoint> findByBusLicensePlateOrderByTimestampAsc(String licensePlate);
    
    GeoPoint findTopByBusLicensePlateOrderByTimestampDesc(String licensePlate);
}

