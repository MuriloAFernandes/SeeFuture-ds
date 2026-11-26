package com.SeeFutureds.SeeFuturedsapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;

@Table("semente")
public class Semente {
    @Id
    private Long id;
    private String nome;
    private BigDecimal precoPorKg;
    private Double estoqueKg;

    public Semente() {}

    public Semente(String nome, BigDecimal precoPorKg, Double estoqueKg) {
        this.nome = nome;
        this.precoPorKg = precoPorKg;
        this.estoqueKg = estoqueKg;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getPrecoPorKg() { return precoPorKg; }
    public void setPrecoPorKg(BigDecimal precoPorKg) { this.precoPorKg = precoPorKg; }
    public Double getEstoqueKg() { return estoqueKg; }
    public void setEstoqueKg(Double estoqueKg) { this.estoqueKg = estoqueKg; }
}