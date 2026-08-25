package br.com.davi.guiche_api.dto.guiche;

public class GuicheResponseDTO {
    private Long id;
    private String nome;
    private Boolean ativo;

    public GuicheResponseDTO(Long id, String nome, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Boolean getAtivo() {
        return ativo;
    }
}