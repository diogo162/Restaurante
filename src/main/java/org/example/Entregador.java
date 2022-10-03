package org.example;

import com.sun.istack.NotNull;

public class Entregador extends Funcionario{
    @NotNull
    private int CNH;
    @NotNull
    private String veiculo;
    @NotNull
    private float horas;
    @NotNull
    private float salario_hora;
}
