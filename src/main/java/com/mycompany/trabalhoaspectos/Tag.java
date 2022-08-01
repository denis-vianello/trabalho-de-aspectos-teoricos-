/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoaspectos;

import java.util.Stack;

/**
 *
 * @author alvar
 */
public class Tag {
    private String id;
    private String def;
    private Automato a;
    
    public Automato gerarAutomato(String s){
        Stack pilha = new Stack();
        int e = 1;
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)) {
                case '+':{
                    Automato a1 = (Automato) pilha.pop();
                    Automato a2 = (Automato) pilha.pop();
                    Automato novo = new Automato();
                    novo.getEstados().addAll(a2.getEstados());
                    novo.getEstados().addAll(a1.getEstados());
                    novo.getEstados().add(e);
                    novo.getIniciais().add(e);
                    for(int j=0;j<a1.getIniciais().size();j++){
                        Transicao t = new Transicao();
                        t.getSimbolos().add("\\l");
                        t.setOrigem(e);
                        t.setDestino(a1.getIniciais().get(j));
                        novo.getTransicoes().add(t);
                    }
                    for(int j=0;j<a2.getIniciais().size();j++){
                        Transicao t = new Transicao();
                        t.getSimbolos().add("\\l");
                        t.setOrigem(e);
                        t.setDestino(a2.getIniciais().get(j));
                        novo.getTransicoes().add(t);
                    }
                    e++;
                    novo.getEstados().add(e);
                    novo.getFinais().add(e);
                    for(int j=0;j<a1.getFinais().size();j++){
                        Transicao t = new Transicao();
                        t.getSimbolos().add("\\l");
                        t.setOrigem(a1.getFinais().get(j));
                        t.setDestino(e);
                        novo.getTransicoes().add(t);
                    }
                    for(int j=0;j<a2.getFinais().size();j++){
                        Transicao t = new Transicao();
                        t.getSimbolos().add("\\l");
                        t.setOrigem(a1.getFinais().get(j));
                        t.setDestino(e);
                        novo.getTransicoes().add(t);
                    }
                    e++;
                    pilha.push(novo);
                    break;}
                case '.':{
                    Automato a1 = (Automato) pilha.pop();
                    Automato a2 = (Automato) pilha.pop();
                    Automato novo = new Automato();
                    novo.getEstados().addAll(a2.getEstados());
                    novo.getEstados().addAll(a1.getEstados());
                    novo.getFinais().addAll(a1.getFinais());
                    novo.getIniciais().addAll(a2.getIniciais());
                    novo.getTransicoes().addAll(a2.getTransicoes());
                    novo.getTransicoes().addAll(a1.getTransicoes());
                    for(int j=0;j<a2.getFinais().size();j++){
                        for(int k=0;k<a2.getFinais().size();k++){
                        Transicao t = new Transicao();
                        t.getSimbolos().add("\\l");
                        t.setOrigem(a2.getFinais().get(j));
                        t.setDestino(a1.getIniciais().get(k));
                        novo.getTransicoes().add(t);
                        }
                    }
                    pilha.push(novo);
                    break;}
                case '*':{
                    Automato a1 = (Automato) pilha.pop();
                    Automato novo = new Automato();
                    novo.getEstados().addAll(a1.getEstados());
                    novo.getFinais().addAll(a1.getIniciais());
                    novo.getIniciais().addAll(a1.getIniciais());
                    novo.getTransicoes().addAll(a1.getTransicoes());
                    for(int j=0;j<a1.getFinais().size();j++){
                        for(int k=0;k<a1.getFinais().size();k++){
                        Transicao t = new Transicao();
                        t.getSimbolos().add("\\l");
                        t.setOrigem(a1.getFinais().get(j));
                        t.setDestino(a1.getIniciais().get(k));
                        novo.getTransicoes().add(t);
                        }
                    }
                    pilha.push(novo);
                    break;}
                default:{
                    Transicao t = new Transicao();
                    Automato aux = new Automato();
                    aux.getEstados().add(e);
                    aux.getIniciais().add(e);
                    t.setOrigem(e);
                    e++;
                    aux.getEstados().add(e);
                    aux.getFinais().add(e);
                    t.setDestino(e);
                    e++;
                    if(s.charAt(i) != 92){
                        String str;
                        str = Character.toString(s.charAt(i));
                        t.getSimbolos().add(str);
                    }else{
                        String str;
                        str = Character.toString(s.charAt(i));
                        i++;
                        str+=s.charAt(i);    
                        t.getSimbolos().add(str);
                    }
                    aux.getTransicoes().add(t);
                    pilha.push(aux);
                    break;}
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public Automato getA() {
        return a;
    }

    public void setA(Automato a) {
        this.a = a;
    }
    
    
}
