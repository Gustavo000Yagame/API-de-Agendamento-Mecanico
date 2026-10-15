package com.agendamento.api_agendamento.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "TbAgendamento")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;

    @Column(nullable = false)
    private String nomePessoa;

    @Column(nullable = false)
    private String placaVeiculo;

    @Column(nullable = false)
    private String veiculo;

    @Column(nullable = false)
    private String statusAtual;

    private LocalDate dataEntrada = LocalDate.now();
    private LocalTime horaEntrada = LocalTime.now();
}
