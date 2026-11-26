package com.SeeFutureds.SeeFuturedsapi.dto;

public record RespostaPedidoDTO(
    Long pedidoId,
    String status,
    NotaClienteDTO notaCliente,
    NotaEntregadorDTO notaEntregador
) {}