package com.mycompany.lojadesapatos;

// Importa a classe ConversorNumeros de outro pacote
import com.mycompany.lojadesapatos.ConversorNumeros;


import com.mycompany.lojadesapatos.Sapatos;


import javax.swing.JOptionPane;

public class Vender {
    
    // Atributo que armazena o valor total da venda
    private double valorTotal;
    // Porcentagem de desconto aplicada na venda (10%)
    private double percentualDesconto = 0.1;
    // Método responsável por realizar a venda de um sapato
    public void venderSapato(Sapatos sapato) {
        
        // Solicita ao usuário a quantidade que deseja vender 
        String entrada = JOptionPane.showInputDialog(null, "Quantidade a vender:");
        
        // Converte a entrada de texto para um número inteiro
        int quantidade = ConversorNumeros.stringparaInt(entrada);

        // Verifica se há estoque suficiente para a quantidade desejada
        if ((quantidade <= Estoque.qtdEstoque) == true) {
            
            // Calcula o valor total da venda sem desconto
            valorTotal = sapato.getPreco() * quantidade;

            // Aplica o desconto de 10%
            valorTotal = valorTotal - (valorTotal * percentualDesconto);

            // Exibe o valor final da venda com desconto
            JOptionPane.showMessageDialog(null, "Venda realizada!\nValor total com desconto: R$ " + valorTotal);
            
            //Atualiza a quantia no Estoque
            Estoque.qtdEstoque -= quantidade;
        
        } else {
            // Caso não haja estoque suficiente, exibe mensagem de erro
            JOptionPane.showMessageDialog(null, "Estoque insuficiente.");         }
    }
}
