package com.SeeFutureds.SeeFuturedsapi.controller;

import com.SeeFutureds.SeeFuturedsapi.dto.NovoPedidoDTO;
import com.SeeFutureds.SeeFuturedsapi.dto.RespostaPedidoDTO;
import com.SeeFutureds.SeeFuturedsapi.model.Pedido;
import com.SeeFutureds.SeeFuturedsapi.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Recebe o pedido, dá baixa no estoque e retorna Nota do Cliente + Nota do Entregador
    // POST http://localhost:8080/api/pedidos
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaPedidoDTO criarPedido(@RequestBody NovoPedidoDTO dados) {
        return pedidoService.registrarPedido(dados);
    }

    // Lista os pedidos com status RECEBIDO para o entregador preparar
    // GET http://localhost:8080/api/pedidos/pendentes
    @GetMapping("/pendentes")
    public List<Pedido> listarPendentes() {
        return pedidoService.listarPedidosPendentes();
    }

    // Marca o pedido como entregue (ex: PATCH http://localhost:8080/api/pedidos/1/entregue)
    @PatchMapping("/{id}/entregue")
    public Pedido finalizarEntrega(@PathVariable Long id) {
        return pedidoService.marcarComoEntregue(id);
    }
}