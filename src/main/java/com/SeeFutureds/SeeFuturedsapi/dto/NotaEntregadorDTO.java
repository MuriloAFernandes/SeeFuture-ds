package com.SeeFutureds.SeeFuturedsapi.dto;

public record NotaEntregadorDTO(
    String codigoSeparacao,
    String instrucaoEstoque,
    String enderecoDestino,
    String telefoneContato
) {}