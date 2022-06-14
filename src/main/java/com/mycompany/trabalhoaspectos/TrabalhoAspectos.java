/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.trabalhoaspectos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PICHAU
 */
public class TrabalhoAspectos {
    static void deftag(ArrayList<String> tags,ArrayList<String> definicao,String a){
        String tag = "";
        for(int i=0;i < a.indexOf(":");i++){
            if(a.charAt(i) == 32){
                System.out.println("[ERROR] a tag possui espacos antes de :");
                return;
            }
            else{
            tag += a.charAt(i);
            System.out.println(tag); //teste de tag tira isso 
            }
        }
        
        if(tags.isEmpty()){
            tags.add(tag);
            definicao.add(a.substring(a.indexOf(":")+1));
            }else{
                for(int i = 0;i < tags.size();i ++){
                    if(tag.equals(tags.get(i))){
                    System.out.println("[ERROR] uma tag com este nome ja foi definida");
                    return;
                    }
                }
                
                tags.add(tag);
                definicao.add(a.substring(a.indexOf(":")+1)); 
            }   
    }

    public static void main(String[] args) {
        System.out.println("Digite a opcao desejada"); 
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        //String a = "var x+y+z";
        //System.out.println(a);
        String a;
        String tag = "";
        String content = "deu erro";
        //System.out.println(tag);
        //System.out.println(content);
        ArrayList<String> tags = new ArrayList<>();
        ArrayList<String> definicao = new ArrayList<>();
        int x = 1, j = 1, k = 1;
        while(x == 1){
            a = teclado.next();
            //System.out.println(a); checagem da string TIRA ISSO!!!!
            if(a.charAt(0) == 58){
                switch(a.charAt(1)){
                // :d
                case 100 :{
                    //System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                // :c
                case 99 :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                // :o
                case 111 :{
                    //System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                // :p
                case 112 :{
                    //System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                // :a
                case 97 :{
                    //System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                // :l
                case 108 :{
                    if(tags.isEmpty()){
                        System.out.println("[WARNING] nao existem definicoes de tags na memoria");
                    }
                    else{
                        for(int i = 0;i < tags.size();i ++){
                            System.out.print(tags.get(i) + ":");
                            System.out.println(definicao.get(i));
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
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                default:
                    System.out.println("[ERROR] comando nao reconhecido");
                    
            }
            }else{
            if(a.contains(": ")){                
                deftag(tags,definicao,a);                        
                }
                else{
                    System.out.println("[ERROR] a tag nao possui ': '");
                } 
            }
        }
    }//fecha o main 
           
}
