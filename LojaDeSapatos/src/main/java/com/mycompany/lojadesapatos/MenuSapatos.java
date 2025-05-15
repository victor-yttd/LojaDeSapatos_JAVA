package com.mycompany.lojadesapatos;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuSapatos extends JFrame {

    private JButton bCadSapato, bCadEstoque, bConSapato, bConEstoque, bCadVenda;

    private Sapatos sapato = new Sapatos();
    private Estoque estoque = new Estoque();
    private EntradaSaidaDados io = new EntradaSaidaDados();

    public MenuSapatos() {
        super("Loja de Sapatos");

        Container tela = getContentPane();
        setLayout(null);

        // Instanciando os botões
        bCadSapato = new JButton("Cadastrar Sapato");
        bCadEstoque = new JButton("Cadastrar Estoque");
        bConSapato = new JButton("Consultar Sapato");
        bConEstoque = new JButton("Consultar Estoque");
        bCadVenda = new JButton("Cadastrar Venda");

        // Posicionando os botões
        bCadSapato.setBounds(50, 30, 180, 30);
        bCadEstoque.setBounds(50, 70, 180, 30);
        bConSapato.setBounds(50, 110, 180, 30);
        bConEstoque.setBounds(50, 150, 180, 30);
        bCadVenda.setBounds(50, 190, 180, 30);

        // Adicionando ações aos botões
        bCadSapato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String precoStr = io.entradaDados("Digite o preço do sapato:");
                String descricao = io.entradaDados("Digite a descrição:");

                double preco = ConversorNumeros.stringparaDouble(precoStr);

                sapato.cadastraSapato(preco, descricao);
                io.saidaDados("Sapato cadastrado com sucesso!");
            }
        });

        bCadEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String qtdStr = io.entradaDados("Digite a quantidade para o estoque:");
                int qtd = ConversorNumeros.stringparaInt(qtdStr);
                estoque.cadastrarEstoque(qtd);
                io.saidaDados("Estoque cadastrado com sucesso!");
            }
        });

        bConSapato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                io.saidaDados(sapato.consultaSapato());
            }
        });

        bConEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                io.saidaDados("Quantidade no estoque: " + estoque.consultarEstoque());
            }
        });

        bCadVenda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Vender venda = new Vender();
                venda.venderSapato(sapato);
            }
        });

        // Adicionando os botões na tela
        tela.add(bCadSapato);
        tela.add(bCadEstoque);
        tela.add(bConSapato);
        tela.add(bConEstoque);
        tela.add(bCadVenda);

        // Configurações da janela
        tela.setBackground(new Color(235, 233, 117));
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
