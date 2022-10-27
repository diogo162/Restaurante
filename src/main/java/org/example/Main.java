package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.servicos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        HibernateUtil hu = new HibernateUtil();
        SessionFactory sessionFactory = hu.getSessionFactory();
        Session session = sessionFactory.openSession();
        gerenteServico gerente = new gerenteImplementar();
        Scanner senha = new Scanner(System.in);
        pedidoServico pedido = new pedidoImplementar();
        mesaServico mesa = new mesaImplementar();
        itemPedidoServico item = new itemPedidoImplementar();
        clienteServico clientes = new clienteImplementar();
        ArrayList<Float> carrinho = new ArrayList<>();
        ArrayList<ItemComer> carrinhoItemComer = new ArrayList<>();
        ArrayList<ItemPedido> carrinhoItemPedido = new ArrayList<>();
        ItemPedido itemP = new ItemPedido();
        Boolean pedindo = true;
        LocalDate localDate = LocalDate.now();
        System.out.println("Bem-vindo, digite sua senha");
        String gerenteSenha = senha.nextLine();
        float valor = 0;

        if (!gerente.verificarSenha(gerenteSenha)) {
            Scanner leitor = new Scanner(System.in);
            System.out.print("Escolha a função:\n1)Mesas\n2)Delivery\n3)Funcionários\n4)Ver cardápio\n5)criar pedido\n6)Sair");
            int escolha = leitor.nextInt();
            while (escolha != 6) {
                switch (escolha) {
                    case (1):
                        System.out.println("Mesas:");
                        mesa.listarMesas();
                        System.out.print("Escolha a função:\n1)Mesas\n2)Estoque\n3)Delivery\n4)Funcionários\n5)Ver cardápio\n6)Sair");
                        escolha = leitor.nextInt();
                        break;
                    case (2):
                        System.out.println("Delivery?");
                        mesa.listarMesasDelivery();
                        System.out.print("Escolha a função:\n1)Mesas\n2)Estoque\n3)Delivery\n4)Funcionários\n5)Ver cardápio\n6)Sair");
                        escolha = leitor.nextInt();
                        break;
                    case (3):
                        System.out.println("Funcionários:");
                        gerente.listarFuncionarios();
                        System.out.print("Escolha a função:\n1)Mesas\n2)Estoque\n3)Delivery\n4)Funcionários\n5)Ver cardápio\n6)Sair");
                        escolha = leitor.nextInt();
                        break;

                    case (4):
                        item.listarCardapio();
                        escolha = leitor.nextInt();
                        System.out.print("Escolha a função:\n1)Mesas\n2)Estoque\n3)Delivery\n4)Funcionários\n5)Ver cardápio\n6)Sair");
                        break;
                    case (5):
                        while (pedindo){
                            System.out.println("Quais itens?");
                            int contador = 0;
                            itemP.setQuantidade(contador);

                            item.listarCardapio();
                            int item_id = leitor.nextInt();
                            ItemComer iten = session.load(ItemComer.class, item_id);
                            carrinho.add(iten.getValor());
                            carrinhoItemComer.add(iten);
                            System.out.println("Deseja inserir mais algo?\n1)Sim\n2)Não");
                            escolha = leitor.nextInt();
                            if(escolha == 2){
                                pedindo = false;
                            }
                            contador +=1;
                        }
                        System.out.print("Pedido delivery ou local?");
                        String escolha2 = leitor.nextLine();
                        Pedido pedidos= new Pedido();
                        pedidos.setDataPedido(localDate);
                        for(int i=0; i < carrinho.size(); i++){
                            valor = valor + carrinho.get(i);
                        }
//                        ItemPedido(int id_itemPedido, int quantidade, List<ItemComer> item)

                        itemP.setItem(carrinhoItemComer);
                        carrinhoItemPedido.add(itemP);
                        pedidos.setValor(valor);
                        pedidos.setItens(carrinhoItemPedido);
                        pedidos.setTipo(escolha2);
                        if(pedidos.getTipo() == "delivery"){
                            Cliente cliente = new Cliente();
                            pedidos.setCliente(cliente);
                            pedido.criarPedido(pedidos);
                        }else if (pedidos.getTipo() == "delivery"){
                            System.out.println("Qual mesa?");
                            int escolha3 = leitor.nextInt();
                            mesa.fecharMesa(escolha3);
                            Mesa msa = session.load(Mesa.class, escolha3);
                            pedidos.setMesa(msa);
                            pedido.criarPedido(pedidos);
                        }
                        escolha = leitor.nextInt();
                        System.out.print("Escolha a função:\n1)Mesas\n2)Estoque\n3)Delivery\n4)Funcionários\n5)Ver cardápio\n6)Sair");
                }
            }

        }
        else{
            System.out.println("senha incorreta, tente novamente");
        }
        session.close();
        sessionFactory.close();
    }
}