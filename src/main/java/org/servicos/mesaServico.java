package org.servicos;

public interface mesaServico {

    void listarMesas();

    void listarMesasDelivery();

    void abrirMesa(int id);

    void fecharMesa(int id);
}
