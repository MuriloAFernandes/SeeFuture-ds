package com.SeeFutureds.SeeFuturedsapi.repository;

import com.SeeFutureds.SeeFuturedsapi.model.Semente;
import org.springframework.data.repository.ListCrudRepository;

public interface SementeRepository extends ListCrudRepository<Semente, Long> {
    // Herda automaticamente: save(), findById(), findAll(), deleteById(), count(), etc.
}