package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Entity;


@Entity
public class Entregador extends Funcionario{
    @NotNull
    private int CNH;
    @NotNull
    private String veiculo;
    @NotNull
    private float horas;
    @NotNull
    private float salario_hora;

    public Entregador(String cpf, String nome) {
        super(cpf, nome);
    }

    public Entregador() {

    }
}
