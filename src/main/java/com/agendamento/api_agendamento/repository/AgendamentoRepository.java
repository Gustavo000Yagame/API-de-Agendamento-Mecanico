package com.agendamento.api_agendamento.repository;

import com.agendamento.api_agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
