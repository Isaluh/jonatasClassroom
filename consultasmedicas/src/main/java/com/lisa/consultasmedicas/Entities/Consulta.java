package com.lisa.consultasmedicas.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data; 

    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;

    @Column 
    private int minutosConsulta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Medico medico; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status; 

    public static enum StatusConsulta {
        AGENDADA,
        CANCELADA,
        REALIZADA;
    }

    public Consulta() {
    }

    public Consulta(Integer id, LocalDate data, LocalTime hora, int minutosConsulta, Medico medico, Paciente paciente,
            StatusConsulta status) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.minutosConsulta = minutosConsulta;
        this.medico = medico;
        this.paciente = paciente;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getMinutosConsulta() {
        return minutosConsulta;
    }

    public void setMinutosConsulta(int minutosConsulta) {
        this.minutosConsulta = minutosConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
}