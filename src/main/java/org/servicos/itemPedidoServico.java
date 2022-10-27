package org.servicos;

import org.example.itemPedido;

public interface itemPedidoServico {

    void adicionarItem(int id, int quantidade, itemPedido item);

    void removerItem(int id);

    void atualizarItem(int id);

}
