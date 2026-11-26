package com.SeeFutureds.SeeFuturedsapi.repository;

import com.SeeFutureds.SeeFuturedsapi.model.Agricultor;
import org.springframework.data.repository.ListCrudRepository;
import java.util.Optional;

public interface AgricultorRepository extends ListCrudRepository<Agricultor, Long> {
    // Consulta personalizada: o Spring cria o SQL "SELECT * FROM agricultor WHERE cpf_cnpj = ?" só pelo nome do método
    Optional<Agricultor> findByCpfCnpj(String cpfCnpj);
}