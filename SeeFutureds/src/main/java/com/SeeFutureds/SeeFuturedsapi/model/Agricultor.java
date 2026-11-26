package com.SeeFutureds.SeeFuturedsapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("agricultor")
public class Agricultor {

    @Id
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String enderecoEntrega;
    private String telefone;

    public Agricultor() {
    }

    public Agricultor(String nome, String cpfCnpj, String enderecoEntrega, String telefone) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.enderecoEntrega = enderecoEntrega;
        this.telefone = telefone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpfCnpj() { return cpfCnpj; }
    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }

    public String getEnderecoEntrega() { return enderecoEntrega; }
    public void setEnderecoEntrega(String enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
