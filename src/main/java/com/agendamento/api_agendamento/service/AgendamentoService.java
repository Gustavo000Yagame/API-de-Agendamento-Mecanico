package com.agendamento.api_agendamento.service;

import com.agendamento.api_agendamento.dto.AgendamentoRequestDTO;
import com.agendamento.api_agendamento.dto.AgendamentoResponseDTO;
import com.agendamento.api_agendamento.model.Agendamento;
import com.agendamento.api_agendamento.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    private AgendamentoResponseDTO converteParaResponse(Agendamento agendamento) {
        return new AgendamentoResponseDTO(
                agendamento.getIdAgendamento(),
                agendamento.getNomePessoa(),
                agendamento.getPlacaVeiculo(),
                agendamento.getVeiculo(),
                agendamento.getStatusAtual(),
                agendamento.getDataEntrada(),
                agendamento.getHoraEntrada()
        );
    }

    public List<AgendamentoResponseDTO> listarTodosAgendamentos() {
        return agendamentoRepository.findAll()
                .stream()
                .map(this::converteParaResponse)
                .toList();
    }

    public AgendamentoResponseDTO buscarAgendamentoPorId(Long idAgendamento) {
        Agendamento agendamento = agendamentoRepository.findById(idAgendamento)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + idAgendamento));
        return converteParaResponse(agendamento);
    }

    @Transactional
    public AgendamentoResponseDTO cadastrarAgendamento(AgendamentoRequestDTO dto) {
        Agendamento agendamento = new Agendamento();
        agendamento.setNomePessoa(dto.nomePessoa());
        agendamento.setPlacaVeiculo(dto.placaVeiculo());
        agendamento.setVeiculo(dto.veiculo());
        agendamento.setStatusAtual(dto.statusAtual());
        agendamento.setDataEntrada(dto.dataEntrada());
        agendamento.setHoraEntrada(dto.horaEntrada());

        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
        return converteParaResponse(agendamentoSalvo);
    }

    @Transactional
    public AgendamentoResponseDTO alterarAgendamento(Long idAgendamento, AgendamentoRequestDTO dto) {
        Agendamento agendamento = agendamentoRepository.findById(idAgendamento)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + idAgendamento));

        agendamento.setNomePessoa(dto.nomePessoa());
        agendamento.setPlacaVeiculo(dto.placaVeiculo());
        agendamento.setVeiculo(dto.veiculo());
        agendamento.setStatusAtual(dto.statusAtual());
        agendamento.setDataEntrada(dto.dataEntrada());
        agendamento.setHoraEntrada(dto.horaEntrada());

        Agendamento agendamentoAtualizado = agendamentoRepository.save(agendamento);
        return converteParaResponse(agendamentoAtualizado);
    }

    @Transactional
    public void excluirAgendamento(Long idAgendamento) {
        if (!agendamentoRepository.existsById(idAgendamento)) {
            throw new RuntimeException("Não é possível excluir. Agendamento não encontrado com o ID: " + idAgendamento);
        }
        agendamentoRepository.deleteById(idAgendamento);
    }
}
