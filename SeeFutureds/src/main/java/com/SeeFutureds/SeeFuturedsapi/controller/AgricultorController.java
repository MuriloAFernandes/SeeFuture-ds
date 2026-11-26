package com.SeeFutureds.SeeFuturedsapi.controller;

import com.SeeFutureds.SeeFuturedsapi.model.Agricultor;
import com.SeeFutureds.SeeFuturedsapi.repository.AgricultorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agricultores")
public class AgricultorController {

    private final AgricultorRepository agricultorRepo;

    public AgricultorController(AgricultorRepository agricultorRepo) {
        this.agricultorRepo = agricultorRepo;
    }

    // Cadastra um novo agricultor (POST http://localhost:8080/api/agricultores)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agricultor cadastrar(@RequestBody Agricultor agricultor) {
        return agricultorRepo.save(agricultor);
    }

    // Lista todos os agricultores cadastrados (GET http://localhost:8080/api/agricultores)
    @GetMapping
    public List<Agricultor> listarTodos() {
        return agricultorRepo.findAll();
    }
}