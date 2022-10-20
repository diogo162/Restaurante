package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa{
    @NotNull
    private String cargo;
    private float salario;

    public Funcionario(String cpf, String nome) {
        super(cpf, nome);
    }

    public Funcionario() {
        super();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }
}
