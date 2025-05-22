package com.mycompany.lojadesapatos;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuSapatos extends JFrame {

    private JButton bCadSapato, bCadEstoque, bConSapato, bConEstoque, bCadVenda, bSair;
    private Sapatos sapato = new Sapatos();
    private Estoque estoque = new Estoque();
    private EntradaSaidaDados io = new EntradaSaidaDados();

    // Método público que inicia o menu
    public void executarSapato() {
        executarMenuPrincipal();
    }

    // Método privado que configura a interface gráfica
    private void executarMenuPrincipal() {
        setTitle("Loja de Sapatos");
        Container tela = getContentPane();
        setLayout(null);

        // Instanciando os botões
        bCadSapato = new JButton("Cadastrar Sapato");
        bCadEstoque = new JButton("Cadastrar Estoque");
        bConSapato = new JButton("Consultar Sapato");
        bConEstoque = new JButton("Consultar Estoque");
        bCadVenda = new JButton("Cadastrar Venda");
        bSair = new JButton("Sair");

        // Posicionando os botões
        bCadSapato.setBounds(50, 30, 180, 30);
        bCadEstoque.setBounds(50, 70, 180, 30);
        bConSapato.setBounds(50, 110, 180, 30);
        bConEstoque.setBounds(50, 150, 180, 30);
        bCadVenda.setBounds(50, 190, 180, 30);
        bSair.setBounds(50, 230, 180, 30);

        // Adicionando ações aos botões
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                avaliarOpcaoEscolhida(e);
            }
        };

        bCadSapato.addActionListener(listener);
        bCadEstoque.addActionListener(listener);
        bConSapato.addActionListener(listener);
        bConEstoque.addActionListener(listener);
        bCadVenda.addActionListener(listener);
        bSair.addActionListener(listener);

        // Adicionando botões à tela
        tela.add(bCadSapato);
        tela.add(bCadEstoque);
        tela.add(bConSapato);
        tela.add(bConEstoque);
        tela.add(bCadVenda);
        tela.add(bSair);

        // Configurações da janela
        tela.setBackground(new Color(235, 233, 117));
        setSize(300, 320);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método privado para tratar os eventos dos botões
    private void avaliarOpcaoEscolhida(ActionEvent e) {
        Object origem = e.getSource();

        if (origem == bCadSapato) {  
            String precoStr = io.entradaDados("Digite o preço do sapato:");
            String descricao = io.entradaDados("Digite a descrição:");
            double preco = ConversorNumeros.stringparaDouble(precoStr);
            sapato.cadastraSapato(preco, descricao);
            io.saidaDados("Sapato cadastrado com sucesso!");

        } else if (origem == bCadEstoque) {
            String qtdStr = io.entradaDados("Digite a quantidade para o estoque:");
            int qtd = ConversorNumeros.stringparaInt(qtdStr);
            estoque.cadastrarEstoque(qtd);
            io.saidaDados("Estoque cadastrado com sucesso!");

        } else if (origem == bConSapato) {
            io.saidaDados(sapato.consultaSapato());

        } else if (origem == bConEstoque) {
            io.saidaDados("Quantidade no estoque: " + estoque.consultarEstoque());

        } else if (origem == bCadVenda) {
            Vender venda = new Vender();
            venda.venderSapato(sapato);

        } else if (origem == bSair) {
            System.exit(0);
        }
    }
}
