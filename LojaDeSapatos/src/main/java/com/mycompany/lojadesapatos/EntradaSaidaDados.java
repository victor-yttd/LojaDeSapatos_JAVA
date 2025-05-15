/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadesapatos;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class EntradaSaidaDados {
    
    public String entradaDados(String mensagemEntrada) {
        return JOptionPane.showInputDialog(null, mensagemEntrada);
    }

    public void saidaDados(String mensagemSaida) {
        JOptionPane.showMessageDialog(null, mensagemSaida);

    }
}
