package example.springbootcourse.exercises.sesiones_4_5_6.controllers;

import example.springbootcourse.exercises.sesiones_4_5_6.entities.Laptop;
import example.springbootcourse.exercises.sesiones_4_5_6.repositories.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // obtener todas las laptops
    @GetMapping("api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    // Crear una laptop en base de datos

    @PostMapping("api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));

        // guardar la laptop recibida en la base de datos
        return laptopRepository.save(laptop);
    }
}
