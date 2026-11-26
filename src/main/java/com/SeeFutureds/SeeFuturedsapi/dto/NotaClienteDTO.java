package com.SeeFutureds.SeeFuturedsapi.dto;

import java.math.BigDecimal;

public record NotaClienteDTO(
    String mensagem,
    String nomeAgricultor,
    String itemComprado,
    BigDecimal valorTotal,
    String statusEntrega
) {}