/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.trabalhoaspectos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PICHAU
 */
public class TrabalhoAspectos {
    
    static void divTag(String a,ArrayList<Tag> tags){
        ArrayList<String> resultado= new ArrayList();
        boolean reconhece = false;
        for(int i=0;i<a.length();i++){
            for(int j=0;j<tags.size();j++){
                int estadoAtual;
                for(int k=0;k<tags.get(j).getA().getIniciais().size();k++){
                    estadoAtual = tags.get(j).getA().getIniciais().get(k);
                    for(int l=0;l<tags.get(j).getA().getTransicoes().size();l++){
                        if(tags.get(j).getA().getTransicoes().get(l).getOrigem()==estadoAtual){
                            for(int x=0;x<tags.get(j).getA().getTransicoes().get(l).getSimbolos().size();x++){
                                if(tags.get(j).getA().getTransicoes().get(l).getSimbolos().get(x).equals(a)){
                                    estadoAtual = tags.get(j).getA().getTransicoes().get(l).getDestino();
                                    for(int y=0;y<tags.get(j).getA().getFinais().size();y++){
                                        if(tags.get(j).getA().getFinais().get(y)==estadoAtual){
                                            resultado.add(tags.get(j).getId());
                                            reconhece = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
            }
                
        }
        for(int i=0;i<resultado.size();i++){
            System.out.print(resultado.get(i)+" ");
        }
    }
    
    static void deftag(ArrayList<Tag> tags,String a){
        String tag = "";
        for(int i=0;i < a.indexOf(":");i++){
            if(a.charAt(i) == 32){
                System.out.println("[ERROR] a tag possui espacos antes de :");
                return;
            }
            else{
            tag += a.charAt(i);
            //System.out.println(tag); //teste de tag tira isso 
            }
        }
        
        if(tags.isEmpty()){
            Tag aux = new Tag();
            aux.setId(tag);
            aux.setDef(a.substring(a.indexOf(": ")+2));
            Automato automato = aux.gerarAutomato(aux.getDef());
            aux.setA(automato);
            tags.add(aux);
            }else{
                for(int i = 0;i < tags.size();i ++){
                    if(tag.equals(tags.get(i).getId())){
                    System.out.println("[ERROR] uma tag com este nome ja foi definida");
                    return;
                    }
                }
                Tag aux = new Tag();
                aux.setId(tag);
                aux.setDef(a.substring(a.indexOf(": ")+2));
                Automato automato = aux.gerarAutomato(aux.getDef());
                aux.setA(automato);
                tags.add(aux);
            } 
        System.out.println("[INFO] A tag foi carregada");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Digite a opcao desejada"); 
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        //String a = "var x+y+z";
        //System.out.println(a);
        String a;
        String path;
        //String content = "deu erro";
        //System.out.println(tag);
        //System.out.println(content);
        ArrayList<Tag> tags = new ArrayList<>();
        ///////////////ArrayList<String> definicao = new ArrayList<>();//
        ArrayList<String> content = new ArrayList<>();
        int x = 1, j = 1, k = 1;
        while(x == 1){
            a = teclado.next();
            //System.out.println(a); checagem da string TIRA ISSO!!!!
            if(a.charAt(0) == 58){
                switch(a.charAt(1)){
                // :d
                case 100 :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                // :c
                case 99 :{
                    path = a.substring(a.indexOf(" ")+1);
                    try{
                    ManipuladorArquivo.leitor(path,content);
                    if(content.isEmpty()){
                        System.out.println("[WARNING] nao existem definicoes de tags na memoria");
                    }
                    else{
                        for(int i = 0;i < content.size();i ++){
                            deftag(tags,content.get(i));                             
                        }
                        System.out.println("[INFO] As definicoes de tags foram carregadas");
                    }
                    }catch(Exception e){
                        System.out.println("[ERROR] Erro ao abrir o arquivo");
                        
                    }
                    break;
                }
                // :o
                case 111 :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                // :p
                case 112 :{
                    divTag(a,tags);
                    break;
                }
                // :a
                case 97 :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                // :l
                case 108 :{
                    if(tags.isEmpty()){
                        System.out.println("[WARNING] nao existem definicoes de tags na memoria");
                    }
                    else{
                        for(int i = 0;i < tags.size();i ++){
                            System.out.print(tags.get(i) + ": ");
                            System.out.println(tags.get(i).getDef());
                        }    
                    }
                    break;
                }
                // :q
                case 113 :{
                    x=0;
                    break;
                }
                // :s
                case 115 :{
                    path = a.substring(a.indexOf(" ")+1);
                    if(tags.isEmpty()){
                        System.out.println("[WARNING] Nao existem tags para serem salvas");
                    }else{
                        String aAux = "";
                        for(int i = 0;i < tags.size();i++ ){
                            a = tags.get(i)+": "+tags.get(i).getDef();
                            aAux += a+"\n";
                        }
                        ManipuladorArquivo.escritor(path,aAux);
                        System.out.println("[INFO] As tags foram salvas");
                    }
                    break;
                }
                default:
                    System.out.println("[ERROR] comando nao reconhecido");
                    
            }
            }else{
            if(a.contains(": ")){                
                deftag(tags,a);                        
                }
                else{
                    System.out.println("[ERROR] a tag nao possui ': '");
                } 
            }
        }
    }//fecha o main 
           
}
