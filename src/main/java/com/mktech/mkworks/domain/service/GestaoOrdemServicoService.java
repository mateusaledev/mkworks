package com.mktech.mkworks.domain.service;

import com.mktech.mkworks.api.model.Comentario;
import com.mktech.mkworks.domain.exception.NegocioException;
import com.mktech.mkworks.domain.model.Cliente;
import com.mktech.mkworks.domain.model.OrdemServico;
import com.mktech.mkworks.domain.model.StatusOrdemServico;
import com.mktech.mkworks.domain.repository.ClienteRepository;
import com.mktech.mkworks.domain.repository.ComentarioRepository;
import com.mktech.mkworks.domain.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public OrdemServico criar(OrdemServico ordemServico) {
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));

        ordemServico.setCliente(cliente);
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(OffsetDateTime.now());

        return ordemServicoRepository.save(ordemServico);
    }

    public void finalizar(Long ordemServicoId) {
        OrdemServico ordemServico = buscar(ordemServicoId);

        ordemServico.finalizar();

        ordemServicoRepository.save(ordemServico);
    }

    public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
        OrdemServico ordemServico = buscar(ordemServicoId);

        Comentario comentario = new Comentario();
        comentario.setDataEnvio(OffsetDateTime.now());
        comentario.setDescricao(descricao);
        comentario.setOrdemServico(ordemServico);

        return comentarioRepository.save(comentario);
    }

    private OrdemServico buscar(Long ordemServicoId) {
        return ordemServicoRepository.findById(ordemServicoId)
                .orElseThrow(() -> new NegocioException("Ordem de serviço não encontrada"));
    }
}