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

// ==============================================
// GUIA RAPIDA CREAR PROYECTO SPRING BOOT EN VS CODE
// ==============================================
//
//  Abrir wizard de Spring
// Ctrl + Shift + P
// escribir: Spring Initializr
// seleccionar: Spring Initializr: Create a Maven Project
//
//  Elegir versión de Spring Boot
// seleccionar la más reciente 3.x.x
//
//  Lenguaje
// seleccionar: Java
//
//  GroupId (paquete raíz)
// ejemplo: com.example
// ejemplo: edu.icesi
//
//  ArtifactId (nombre del proyecto)
// ejemplo: demo
// ejemplo: metro
//
//  Packaging
// seleccionar: Jar 
// (NO seleccionar War)
//
//  Java Version
// seleccionar: 17 
//
//  Buscar dependencias (MUY IMPORTANTE)
// escribir y seleccionar:
//
// → Spring Web
// → Spring Data JPA
// → H2 Database
//
//  Elegir carpeta donde guardar el proyecto
// luego abrir el proyecto cuando VS Code lo pregunte
//
//  Ejecutar el proyecto
// abrir terminal dentro del proyecto y correr:
//
// mvn spring-boot:run
//
// Si todo está bien debe aparecer:
// Tomcat started on port 8080
//
// ==============================================
// FLUJO MENTAL PARA PARCIAL
// Ctrl+Shift+P → Spring Initializr → Maven
// Spring Boot 3.x → Java → Jar → Java 17
// Dependencias: Web + JPA + H2 → Finish → Run
// ==============================================
// ==============================================
// GUIA RAPIDA ENDPOINTS REST - SPRING BOOT
// ==============================================
//
// URL BASE DEL PROYECTO
// http://localhost:8080/api
//
// ==============================================
//  Obtener lista filtrada por atributo
// ==============================================
//
// EJEMPLO PROYECTO BUSES:
//
// URL COMPLETA:
// http://localhost:8080/api/buses/by-route/P27
//
// ENDPOINT:
//
// @GetMapping("/buses/by-route/{routeName}")
// public List<Bus> getBusesByRoute(@PathVariable String routeName){
//     return busRepository.findByRouteRouteName(routeName);
// }
//
//  ADAPTACION A OTROS PROYECTOS:
//
// Ejemplo universidad:
// http://localhost:8080/api/students/by-program/Sistemas
//
// @GetMapping("/students/by-program/{program}")
// public List<Student> getByProgram(@PathVariable String program){
//     return studentRepository.findByProgram(program);
// }
//
// ==============================================
//  Obtener lista relacionada (historial, recorrido, etc)
// ==============================================
//
// EJEMPLO BUSES:
//
// URL COMPLETA:
// http://localhost:8080/api/buses/ABC123/geoPoints
//
// ENDPOINT:
//
// @GetMapping("/buses/{plate}/geoPoints")
// public List<GeoPoint> getGeoPoints(@PathVariable String plate){
//     return geoPointRepository
//            .findByBusLicensePlateOrderByTimestampAsc(plate);
// }
//
//  ADAPTACION:
//
// Ejemplo pedidos de cliente:
// http://localhost:8080/api/customers/10/orders
//
// @GetMapping("/customers/{id}/orders")
// public List<Order> orders(@PathVariable Integer id){
//     return orderRepository.findByCustomerId(id);
// }
//
// ==============================================
// 3️ Obtener un solo registro especial (último, primero)
// ==============================================
//
// EJEMPLO BUSES:
//
// URL COMPLETA:
// http://localhost:8080/api/buses/ABC123/last-location
//
// ENDPOINT:
//
// @GetMapping("/buses/{plate}/last-location")
// public GeoPoint last(@PathVariable String plate){
//     return geoPointRepository
//            .findTopByBusLicensePlateOrderByTimestampDesc(plate);
// }
//
// ADAPTACION:
//
// Ejemplo último pago usuario:
// http://localhost:8080/api/users/5/last-payment
//
// @GetMapping("/users/{id}/last-payment")
// public Payment lastPayment(@PathVariable Integer id){
//     return paymentRepository
//            .findTopByUserIdOrderByDateDesc(id);
// }
//
// ==============================================
// REGLA GENERAL PARA CREAR ENDPOINTS
// ==============================================
//
// URL estructura:
//
// http://localhost:8080/api/recurso/filtro/valor
//
// ejemplos:
//
// http://localhost:8080/api/products/by-category/Electronics
// http://localhost:8080/api/orders/by-status/PAID
// http://localhost:8080/api/users/3/orders
// http://localhost:8080/api/buses/ABC123/last-location
//
// 
// FLUJO MENTAL PARA PARCIAL
//
//
// 1️¿Qué entidad devuelve?
// 2️¿Qué atributo filtra?
// 3️ ¿Hay navegación entre entidades?
// 4️ Crear query method
// 5️ Crear endpoint GET con @PathVariable
//
// ==============================================