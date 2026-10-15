package com.agendamento.api_agendamento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendamentoResponseDTO(

 Long idAGendamento,
 String nomePessoa,
 String placaVeiculo,
 String veiculo,
 String statusAtual,
 LocalDate dataEntrada,
 LocalTime horaEntrada
) {}
