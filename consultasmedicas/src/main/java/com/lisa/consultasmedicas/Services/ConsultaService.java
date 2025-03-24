package com.lisa.consultasmedicas.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisa.consultasmedicas.Entities.Consulta;
import com.lisa.consultasmedicas.Entities.Consulta.StatusConsulta;
import com.lisa.consultasmedicas.Entities.Medico;
import com.lisa.consultasmedicas.Entities.Paciente;
import com.lisa.consultasmedicas.Repositories.ConsultaRepository;
import com.lisa.consultasmedicas.Repositories.MedicoRepository;
import com.lisa.consultasmedicas.Repositories.PacienteRepository;

@Service
public class ConsultaService {
    
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Consulta> findAll() {
        List<Consulta> consultas = consultaRepository.findAll();
        if (consultas.isEmpty()) {
            throw new RuntimeException("Não há consultas registrados no sistema ainda.");
        }
        return consultas;
    }

    public Consulta findById(Integer id) {
        return consultaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Consulta não encontrado do ID: " + id));
    }

    private boolean medicoDisponivel(Medico medico, LocalDate data, LocalTime hora, int minutosConsulta) {
        LocalDateTime dataHoraInicio = LocalDateTime.of(data, hora);
        LocalDateTime dataHoraFim = dataHoraInicio.plusMinutes(minutosConsulta);
    
        List<Consulta> consultas = consultaRepository.disponibilidadeMedico(
                medico.getId(), 
                dataHoraInicio, 
                dataHoraFim
        );
    
        return consultas.isEmpty();
    }
    
    private boolean pacienteDisponivel(Paciente paciente, LocalDate data, LocalTime hora, int minutosConsulta) {
        LocalDateTime dataHoraInicio = LocalDateTime.of(data, hora);
        LocalDateTime dataHoraFim = dataHoraInicio.plusMinutes(minutosConsulta);
    
        List<Consulta> consultas = consultaRepository.disponibilidadePaciente(
                paciente.getId(), 
                dataHoraInicio, 
                dataHoraFim
        );

        return consultas.isEmpty();
    }

    public Consulta saveConsulta(Consulta consulta) {
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não pode ser registrada: Falta de informações.");
        }

        if(consulta.getMedico().getId() != null){
            medicoRepository.findById(consulta.getMedico().getId());
        }

        if(consulta.getPaciente().getId() != null){
            pacienteRepository.findById(consulta.getMedico().getId());
        }

        if (consulta.getStatus() == null) {
            consulta.setStatus(StatusConsulta.AGENDADA);
        }

        if (!medicoDisponivel(consulta.getMedico(), consulta.getData(), consulta.getHora(), consulta.getMinutosConsulta())) {
            throw new RuntimeException("O médico já tem uma consulta agendada para esse horário.");
        }

        if (!pacienteDisponivel(consulta.getPaciente(), consulta.getData(), consulta.getHora(), consulta.getMinutosConsulta())) {
            throw new RuntimeException("O paciente já tem uma consulta agendada para esse horário.");
        }

        return consultaRepository.save(consulta);
    }

    public Consulta updateStatus(Integer id, StatusConsulta novoStatus) {
        if (id == null || novoStatus == null) {
            throw new IllegalArgumentException("Consulta ID e o novo status não podem ser nulos.");
        }

        Consulta consultaExistente = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com o ID: " + id));


        if (consultaExistente.getStatus() == StatusConsulta.REALIZADA) {
            if (novoStatus == StatusConsulta.CANCELADA || novoStatus == StatusConsulta.AGENDADA) {
                throw new RuntimeException("Consulta realizada não pode ser alterada para CANCELADA ou AGENDADA.");
            }
        }

        if (consultaExistente.getStatus() == StatusConsulta.CANCELADA) {
            throw new RuntimeException("A consulta já CANCELADA não pode ser reativada.");
        }

        consultaExistente.setStatus(novoStatus);

        return consultaRepository.save(consultaExistente);
    }
}
