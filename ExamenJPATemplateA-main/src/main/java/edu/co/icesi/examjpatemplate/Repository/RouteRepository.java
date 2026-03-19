package edu.co.icesi.examjpatemplate.Repository;

import edu.co.icesi.examjpatemplate.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.co.icesi.examjpatemplate.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route,Integer>{
    
}

