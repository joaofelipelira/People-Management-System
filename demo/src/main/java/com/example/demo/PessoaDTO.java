package com.example.demo;

public class PessoaDTO {

    private String nome;
    private String cpf;
    private Integer idade;

    public PessoaDTO() {
    }

    public PessoaDTO(String nome, String cpf, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public static PessoaDTO toDTO(Pessoa pessoa) {
        return new PessoaDTO(pessoa.getNome(), pessoa.getCpf(), pessoa.getIdade());
    }

    public static Pessoa fromDTO(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setIdade(pessoaDTO.getIdade());
        return pessoa;
    }
}
