package org.servicos;

import org.example.ItemPedido;

public interface itemPedidoServico {

    void adicionarItem(int id, int quantidade, ItemPedido item);

    void removerItem(int id);

    void atualizarItem(int id);
}
