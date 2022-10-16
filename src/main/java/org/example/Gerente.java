package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Entity;

@Entity

public class Gerente extends Funcionario{
    @NotNull
    private String senha;

    public Gerente(String cpf, String nome) {
        super(cpf, nome);
    }

    public Gerente() {
        super();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
