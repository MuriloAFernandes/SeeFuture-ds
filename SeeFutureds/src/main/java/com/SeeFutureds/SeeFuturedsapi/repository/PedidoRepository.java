package com.SeeFutureds.SeeFuturedsapi.repository;

import com.SeeFutureds.SeeFuturedsapi.model.Pedido;
import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

public interface PedidoRepository extends ListCrudRepository<Pedido, Long> {
    // Busca pedidos filtrando pela coluna "status" (ex: "RECEBIDO" ou "ENTREGUE")
    List<Pedido> findByStatus(String status);
}
