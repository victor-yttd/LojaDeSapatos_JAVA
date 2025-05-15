/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadesapatos;

/**
 *
 * @author Admin
 */
public class Estoque {

    public static int reduzirEstoque;
    public static int qtdEstoque;

    // Método para cadastrar (definir) a quantidade em estoque
    public void cadastrarEstoque(int quantidade) {
        qtdEstoque = quantidade;
    }

    // Método para consultar a quantidade atual no estoque
    public int consultarEstoque() {
        return qtdEstoque;
    }
    
    public boolean reduzirEstoque(int quantidade) {
        if (quantidade <= qtdEstoque) {
            quantidade -= qtdEstoque;
            return true;
        }
        else {
            return false;
        }
    }
}
