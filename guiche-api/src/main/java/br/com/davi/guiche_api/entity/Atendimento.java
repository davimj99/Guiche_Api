package br.com.davi.guiche_api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "atendimentos")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    @Column(name = "senha_id")
    private Long senhaId;

    private String tipo;

    private Long guiche;

    private Long aluno;

    private Long atendente;

    public Atendimento() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public Long getSenhaId() {
        return senhaId;
    }

    public void setSenhaId(Long senhaId) {
        this.senhaId = senhaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getGuiche() {
        return guiche;
    }

    public void setGuiche(Long guiche) {
        this.guiche = guiche;
    }

    public Long getAluno() {
        return aluno;
    }

    public void setAluno(Long aluno) {
        this.aluno = aluno;
    }

    public Long getAtendente() {
        return atendente;
    }

    public void setAtendente(Long atendente) {
        this.atendente = atendente;
    }
}