package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Id;

public class Pessoa {
    @NotNull
    private String nome;
    @Id
    @NotNull
    private String CPF;
    private int telefone_celular;
    @NotNull
    private Endereco endereco;
}
