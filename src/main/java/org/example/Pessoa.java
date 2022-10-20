package org.example;

import com.sun.istack.NotNull;

import javax.persistence.*;

@MappedSuperclass
public class Pessoa {
    @NotNull
    private String nome;
    @EmbeddedId
    @NotNull
    private String cpf;
    private int telefone_celular;

    @NotNull
    @Embedded
    private Endereco endereco;



    public Pessoa(String cpf, String nome, int telefone_celular) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.telefone_celular = telefone_celular;
    }

    public Pessoa() {
    }

    public Pessoa(String cpf, String nome) {
    }


    public int getTelefone_celular() {
        return telefone_celular;
    }
    public void setTelefone_celular(int telefone_celular) {
        this.telefone_celular = telefone_celular;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }


    protected void setNome(String nome) {
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
