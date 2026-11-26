package com.SeeFutureds.SeeFuturedsapi.dto;

public record NovoPedidoDTO(
    Long agricultorId,
    Long sementeId,
    Double quantidadeKg
) {}