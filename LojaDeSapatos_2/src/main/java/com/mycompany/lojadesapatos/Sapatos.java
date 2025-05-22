
package com.mycompany.lojadesapatos; 

public class Sapatos {
    // Atributos privados da classe
    private String descricao;   // Armazena a descrição do sapato
    private double preco;       // Armazena o preço do sapato
 

    // Método para cadastrar os dados de um sapato
    public void cadastraSapato(double preco, String descricao) {
        this.preco = preco;               // Define o preço informado
        this.descricao = descricao;       // Define a descrição informada
    }

    // Método que retorna as informações do sapato em formato de texto
    public String consultaSapato() {
        return "Descrição: " + descricao + "\nPreço: R$" + preco;
    }

    // Getter que retorna o preço do sapato
    public double getPreco() {
        return preco;
    }
}



