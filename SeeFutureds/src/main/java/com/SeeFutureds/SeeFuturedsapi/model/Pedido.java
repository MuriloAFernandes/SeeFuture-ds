package com.SeeFutureds.SeeFuturedsapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("pedido")
public class Pedido {

    @Id
    private Long id;
    private Long agricultorId; // Guarda apenas o ID do agricultor
    private Long sementeId;    // Guarda apenas o ID da semente
    private Double quantidadeKg;
    private BigDecimal valorTotal;
    private String status;
    private LocalDateTime dataHora;

    public Pedido() {
    }

    public Pedido(Long agricultorId, Long sementeId, Double quantidadeKg, BigDecimal valorTotal, String status) {
        this.agricultorId = agricultorId;
        this.sementeId = sementeId;
        this.quantidadeKg = quantidadeKg;
        this.valorTotal = valorTotal;
        this.status = status;
        this.dataHora = LocalDateTime.now(); // Já preenche com a data e hora exata do pedido
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAgricultorId() { return agricultorId; }
    public void setAgricultorId(Long agricultorId) { this.agricultorId = agricultorId; }

    public Long getSementeId() { return sementeId; }
    public void setSementeId(Long sementeId) { this.sementeId = sementeId; }

    public Double getQuantidadeKg() { return quantidadeKg; }
    public void setQuantidadeKg(Double quantidadeKg) { this.quantidadeKg = quantidadeKg; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}
