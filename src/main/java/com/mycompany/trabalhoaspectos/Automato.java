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
        ArrayList<Fecho> fechos = new ArrayList();
        
        
        for(int j = 0;j<estados.size();j++){
            ArrayList<Integer> f = new ArrayList();
            for(int i=0;i<transicoes.size();i++){
                if(transicoes.get(i).getOrigem()==estados.get(j)){
                    for(int k=0;k<transicoes.get(i).getSimbolos().size();k++){
                        if(transicoes.get(i).getSimbolos().get(k).equals("\\l")){
                           f.add(transicoes.get(i).getDestino());
                           fecho(f);}
                    }
                }
            }
            
            fechos.get(j).getLista().addAll(f);
        }
        
        for(int i=0;i<transicoes.size();i++){
            for(int k=0;k<transicoes.get(i).getSimbolos().size();k++){
                        if(transicoes.get(i).getSimbolos().get(k).equals("\\l")){
                            for(int j=0;j<iniciais.size();j++){
                               if(transicoes.get(i).getOrigem()==iniciais.get(j)){
                                  iniciais.add(transicoes.get(i).getDestino());
                               }
                           }
                           transicoes.remove(i);
                           i--;
                        }
                    }
        }
        ArrayList<Transicao> novas = new ArrayList<>();
        for(int i=0;i<transicoes.size();i++){
            for(int j = 0;j<fechos.get(transicoes.get(i).getDestino()).getLista().size();j++){
                Transicao aux = new Transicao();
                aux.setOrigem(transicoes.get(i).getOrigem());
                aux.setDestino(fechos.get(transicoes.get(i).getDestino()).getLista().get(j));
                for(int k = 0;k<transicoes.get(i).getSimbolos().size();k++){
                    aux.getSimbolos().add((String)transicoes.get(i).getSimbolos().get(k));
                }
                novas.add(aux);
            }
        }
        transicoes.addAll(novas);
        for(int i = 0;i<estados.size();i++){
            for(int j = 0;j<finais.size();j++){
                if(finais.get(j).equals(estados.get(i))){i++;}
            }
            boolean x = chegaNoFinal(estados.get(i));
            if(x==false){
                for(int k = 0;k<iniciais.size();k++){
                    if(iniciais.get(k).equals(estados.get(i))){iniciais.remove(k);k--;}
                }
                for(int k = 0;k<transicoes.size();k++){
                    if(estados.get(i)==transicoes.get(k).getOrigem()){
                        transicoes.remove(k);
                        k--;
                    }else if(estados.get(i)==transicoes.get(k).getDestino()){
                        transicoes.remove(k);
                        k--;
                    }
                }
                estados.remove(i);
            }
        }  
    }

    public void toAFD() {
    }
    
    public void fecho(ArrayList<Integer> f){
        for(int i = 0;i<f.size();i++){
            for(int j=0;j<transicoes.size();j++){
                if(transicoes.get(j).getOrigem()==f.get(i)){
                    for(int k=0;k<transicoes.get(i).getSimbolos().size();k++){
                        if(transicoes.get(i).getSimbolos().get(k).equals("\\l")){
                           f.add(transicoes.get(i).getDestino());
                           fecho(f);
                        }
                        
                    }
                }
            }
        }
    }
    
    public boolean chegaNoFinal(int estado){
        boolean x = false;
        for(int i=0;i<transicoes.size();i++){
            if(transicoes.get(i).getOrigem()==estado){
                for(int j=0;j<finais.size();j++){
                    if(transicoes.get(i).getDestino()==finais.get(j)){
                        x = true;
                        return x;
                    } 
                }
                x = chegaNoFinal(transicoes.get(i).getDestino());
                if(x==true){return x;}
            }
        }
        return x;
    }

}
    
