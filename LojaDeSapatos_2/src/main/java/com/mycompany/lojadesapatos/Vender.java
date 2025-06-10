package com.mycompany.lojadesapatos;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Vender {

    private double valorTotal;
    private double percentualDesconto = 0.1;

    // Atributos estáticos para controle geral
    private static int totalVendas = 0;
    private static int totalParesVendidos = 0;
    private static double faturamentoTotal = 0;
    private static ArrayList<String> resumoVendas = new ArrayList<>();

    public void venderSapato(Sapatos sapato) {
        String entrada = JOptionPane.showInputDialog(null, "Quantidade a vender:");
        if (entrada == null) return;

        int quantidade = ConversorNumeros.stringparaInt(entrada);

        if (quantidade <= Estoque.qtdEstoque) {
            valorTotal = sapato.getPreco() * quantidade;
            double desconto = valorTotal * percentualDesconto;
            valorTotal -= desconto;

            JOptionPane.showMessageDialog(null, "Venda realizada!\nValor total com desconto: R$ " + String.format("%.2f", valorTotal));

            // Atualiza o estoque
            Estoque.qtdEstoque -= quantidade;

            // Atualiza o controle de vendas
            totalVendas++;
            totalParesVendidos += quantidade;
            faturamentoTotal += valorTotal;

            // Salva resumo
            resumoVendas.add("Venda #" + totalVendas + ": " + quantidade + " par(es) - R$ " + String.format("%.2f", valorTotal));
        } else {
            JOptionPane.showMessageDialog(null, "Estoque insuficiente.");
        }
    }

    // Getters para o relatório
    public static int getTotalVendas() {
        return totalVendas;
    }

    public static int getTotalParesVendidos() {
        return totalParesVendidos;
    }

    public static double getFaturamentoTotal() {
        return faturamentoTotal;
    }

    public static String getResumoVendas() {
        if (resumoVendas.isEmpty()) {
            return "Nenhuma venda registrada.";
        }

        StringBuilder resumo = new StringBuilder();
        for (String linha : resumoVendas) {
            resumo.append(linha).append("\n");
        }
        return resumo.toString();
    }
            }
