package org.example;

import com.sun.istack.NotNull;

import javax.persistence.*;

@MappedSuperclass
public class Pessoa {
    @NotNull
    protected String nome;
    @Id
    @NotNull
    protected String cpf;
    protected int telefone_celular;

    @NotNull
    protected String endereco;

    public Pessoa(String cpf, String nome, int telefone_celular, String endereco) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.telefone_celular = telefone_celular;
        this.endereco = endereco;
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


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
