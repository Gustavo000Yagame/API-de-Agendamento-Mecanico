package com.agendamento.api_agendamento.controller;

import com.agendamento.api_agendamento.dto.AgendamentoRequestDTO;
import com.agendamento.api_agendamento.dto.AgendamentoResponseDTO;
import com.agendamento.api_agendamento.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Controller do agendamento", description = "Rotas para gerenciamento de agendamentos da mecânica")
@RestController
@RequestMapping("/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @Operation(summary = "GET simples para listar todos os agendamentos")
    @GetMapping
    public List<AgendamentoResponseDTO> listarTodosAgendamentos() {
        return agendamentoService.listarTodosAgendamentos();
    }

    @Operation(summary = "POST para cadastrar agendamentos")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoResponseDTO cadastrarAgendamento(@Valid @RequestBody AgendamentoRequestDTO dto) {
        return agendamentoService.cadastrarAgendamento(dto);
    }

    @Operation(summary = "GET {id} para buscar agendamento específico")
    @GetMapping("/buscar/{idAgendamento}")
    public AgendamentoResponseDTO buscarAgendamentoPorId(@PathVariable Long idAgendamento) {
        return agendamentoService.buscarAgendamentoPorId(idAgendamento);
    }

    @Operation(summary = "PUT {id} para atualizar agendamento específico")
    @PutMapping("/atualizar/{idAgendamento}")
    public AgendamentoResponseDTO alterarAgendamento(@PathVariable Long idAgendamento, @Valid @RequestBody AgendamentoRequestDTO dto) {
        return agendamentoService.alterarAgendamento(idAgendamento, dto);
    }

    @Operation(summary = "DELETE {id} para excluir um agendamento")
    @DeleteMapping("/excluir/{idAgendamento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAgendamento(@PathVariable Long idAgendamento) {
        agendamentoService.excluirAgendamento(idAgendamento);
    }
}
