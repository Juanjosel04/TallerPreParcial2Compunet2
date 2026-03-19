package edu.co.icesi.examjpatemplate.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.co.icesi.examjpatemplate.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer>{

    List<Bus> findByRouteRouteName(String routeName);

    
}

// NOMENCLATURA QUERY METHODS (Spring Data JPA)
//
// findBy -> busca registros que cumplan la condición
// Ejemplo:
// findByLicensePlate(String plate)
// Busca buses donde licensePlate = plate
//
// And -> agrega otra condición (AND)
// Ejemplo:
// findByRouteRouteNameAndLicensePlate(String routeName, String plate)
// Busca buses donde route.routeName = routeName AND licensePlate = plate
//
// Or -> agrega alternativa (OR)
// Ejemplo:
// findByLicensePlateOrId(String plate, Integer id)
// Busca buses donde licensePlate = plate OR id = id
//
// OrderBy -> ordena los resultados
// Asc -> orden ascendente
// Desc -> orden descendente
// Ejemplo:
// findByBusLicensePlateOrderByTimestampAsc(String plate)
// Devuelve los geopoints del bus ordenados por timestamp de menor a mayor
//
// findByBusLicensePlateOrderByTimestampDesc(String plate)
// Devuelve los geopoints ordenados de más reciente a más antiguo
//
// Top / First -> devuelve solo el primer resultado
// Ejemplo:
// findTopByBusLicensePlateOrderByTimestampDesc(String plate)
// Devuelve el geopoint más reciente del bus
//
// Containing -> equivalente a LIKE %valor%
// Ejemplo:
// findByRouteRouteNameContaining(String name)
// Busca rutas que contengan ese texto en routeName
//
// Between -> busca entre dos valores
// Ejemplo:
// findByTimestampBetween(LocalDateTime start, LocalDateTime end)
// Busca geopoints registrados entre dos tiempos
//
// Navegación entre entidades:
// Se usa el nombre del atributo de la relación + el atributo interno
//
// Ejemplo:
// Bus.route.routeName
// Query method:
// findByRouteRouteName(String routeName)
//
// Otro ejemplo:
// GeoPoint.bus.licensePlate
// Query method:
// findByBusLicensePlate(String plate)
//
// Regla importante:
// El nombre del atributo debe coincidir EXACTAMENTE
// con el atributo definido en la entidad.
//
// Ejemplo:
// Bus tiene -> Route route
// Route tiene -> String routeName
//
// Entonces:
// findByRouteRouteName(String routeName)
//
// Se tienen que usar exactamente los nombres de atributos,
// pero la primera letra se pone en mayúscula (CamelCase).
//
// Ejemplo:
// String routeName (en la clase Route)
// En el query method se escribe:
// RouteName
//
// Ejemplo completo:
// findByRouteRouteName("P27")