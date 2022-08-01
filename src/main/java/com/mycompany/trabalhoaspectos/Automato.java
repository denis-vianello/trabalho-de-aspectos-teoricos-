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
public class Automato {
    private ArrayList<Integer> estados;
    private ArrayList<String> alfabeto;
    private ArrayList<Transicao> transicoes;
    private ArrayList<Integer> iniciais;
    private ArrayList<Integer> finais;

    public ArrayList<Integer> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Integer> estados) {
        this.estados = estados;
    }

    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(ArrayList<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public ArrayList<Transicao> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(ArrayList<Transicao> transicoes) {
        this.transicoes = transicoes;
    }

    public ArrayList<Integer> getIniciais() {
        return iniciais;
    }

    public void setIniciais(ArrayList<Integer> iniciais) {
        this.iniciais = iniciais;
    }

    public ArrayList<Integer> getFinais() {
        return finais;
    }

    public void setFinais(ArrayList<Integer> finais) {
        this.finais = finais;
    }

    public void toAFN() {
        return;
    }

    public void toAFD() {
        return;
    }
    
    
}
