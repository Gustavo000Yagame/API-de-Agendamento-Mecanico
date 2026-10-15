package com.agendamento.api_agendamento.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendamentoRequestDTO(

        @NotNull(message = "Nome é obrigatorio")
        String nomePessoa,
        @NotNull(message = "Numero da placa do veiculo é obrigatorio")
        String placaVeiculo,
        @NotNull(message = "Veiculo é obrigatorio")
        String veiculo,
        @NotNull(message = "Status de andamento é obrigatorio (a fazer) (em andamento) ( finaizado) ")
        String statusAtual,

        LocalDate dataEntrada,
        LocalTime horaEntrada
) {}
