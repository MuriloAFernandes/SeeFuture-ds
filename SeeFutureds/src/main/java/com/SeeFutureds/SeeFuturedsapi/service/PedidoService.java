package com.SeeFutureds.SeeFuturedsapi.service;

import com.SeeFutureds.SeeFuturedsapi.dto.*;
import com.SeeFutureds.SeeFuturedsapi.model.*;
import com.SeeFutureds.SeeFuturedsapi.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepo;
    private final SementeRepository sementeRepo;
    private final AgricultorRepository agricultorRepo;

    public PedidoService(PedidoRepository pedidoRepo, SementeRepository sementeRepo, AgricultorRepository agricultorRepo) {
        this.pedidoRepo = pedidoRepo;
        this.sementeRepo = sementeRepo;
        this.agricultorRepo = agricultorRepo;
    }

    @Transactional
    public RespostaPedidoDTO registrarPedido(NovoPedidoDTO dados) {
        Agricultor agricultor = agricultorRepo.findById(dados.agricultorId())
                .orElseThrow(() -> new RuntimeException("Agricultor não encontrado com ID: " + dados.agricultorId()));

        Semente semente = sementeRepo.findById(dados.sementeId())
                .orElseThrow(() -> new RuntimeException("Semente não encontrada com ID: " + dados.sementeId()));

        if (dados.quantidadeKg() == null || dados.quantidadeKg() <= 0) {
            throw new RuntimeException("A quantidade deve ser maior que zero.");
        }
        if (semente.getEstoqueKg() < dados.quantidadeKg()) {
            throw new RuntimeException("Estoque insuficiente! Disponível: " + semente.getEstoqueKg() + " kg");
        }

        // 1. Dá baixa no estoque
        semente.setEstoqueKg(semente.getEstoqueKg() - dados.quantidadeKg());
        sementeRepo.save(semente);

        // 2. Calcula total e salva o pedido
        BigDecimal valorTotal = semente.getPrecoPorKg().multiply(BigDecimal.valueOf(dados.quantidadeKg()));
        Pedido novoPedido = new Pedido(
                agricultor.getId(),
                semente.getId(),
                dados.quantidadeKg(),
                valorTotal,
                "RECEBIDO"
        );
        Pedido pedidoSalvo = pedidoRepo.save(novoPedido);

        // 3. Gera a Nota do Cliente
        NotaClienteDTO notaCliente = new NotaClienteDTO(
                "Pedido recebido com sucesso!",
                agricultor.getNome(),
                dados.quantidadeKg() + " kg de " + semente.getNome(),
                valorTotal,
                "Aguardando separação para envio"
        );

        // 4. Gera a Nota do Entregador
        NotaEntregadorDTO notaEntregador = new NotaEntregadorDTO(
                "SEP-" + pedidoSalvo.getId(),
                "Retirar " + dados.quantidadeKg() + " kg de " + semente.getNome() + " do estoque",
                agricultor.getEnderecoEntrega(),
                agricultor.getTelefone()
        );

        return new RespostaPedidoDTO(
                pedidoSalvo.getId(),
                pedidoSalvo.getStatus(),
                notaCliente,
                notaEntregador
        );
    }

    public List<Pedido> listarPedidosPendentes() {
        return pedidoRepo.findByStatus("RECEBIDO");
    }

    public Pedido marcarComoEntregue(Long pedidoId) {
        Pedido pedido = pedidoRepo.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus("ENTREGUE");
        return pedidoRepo.save(pedido);
    }
}