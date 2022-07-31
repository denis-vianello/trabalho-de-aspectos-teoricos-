/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoaspectos;

import java.util.ArrayList;

/**
 *
 * @author alvar
 */
public class Transicao {
    private String origem;
    private String destino;
    private ArrayList<String> simbolos;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public ArrayList<String> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(ArrayList<String> simbolos) {
        this.simbolos = simbolos;
    }

}
