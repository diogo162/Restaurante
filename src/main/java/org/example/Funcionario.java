package org.example;

import com.sun.istack.NotNull;

public class Funcionario extends Pessoa{
    @NotNull
    private String cargo;
    private float salario;


    public Funcionario(String cpf, String nome) {
        super(cpf, nome);
    }

    public Funcionario() {

    }
}
