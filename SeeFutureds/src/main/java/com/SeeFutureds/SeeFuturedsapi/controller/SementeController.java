package com.SeeFutureds.SeeFuturedsapi.controller;

import com.SeeFutureds.SeeFuturedsapi.model.Semente;
import com.SeeFutureds.SeeFuturedsapi.repository.SementeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sementes")
public class SementeController {

    private final SementeRepository sementeRepo;

    public SementeController(SementeRepository sementeRepo) {
        this.sementeRepo = sementeRepo;
    }

    // Cadastra uma nova semente no estoque (POST http://localhost:8080/api/sementes)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Semente cadastrar(@RequestBody Semente semente) {
        return sementeRepo.save(semente);
    }

    // Lista todas as sementes disponíveis (GET http://localhost:8080/api/sementes)
    @GetMapping
    public List<Semente> listarTodas() {
        return sementeRepo.findAll();
    }
}