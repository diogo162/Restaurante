package org.example;

import com.sun.istack.NotNull;

public class Gerente extends Funcionario{
    @NotNull
    private String senha;

    public Gerente(String cpf, String nome) {
        super(cpf, nome);
    }


    public boolean verificarSenha(String senha) {
        if (this.senha == senha){
            return true;
        }else{
            return true;
        }
    }
}
