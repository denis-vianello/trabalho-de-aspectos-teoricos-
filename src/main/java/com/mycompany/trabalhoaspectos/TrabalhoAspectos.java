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
        ArrayList<String> tags = new ArrayList<String>();
        int x = 1, j = 1;
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
                    System.out.println("[WARNING] funcao nao implementada");
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
                    System.out.println("[ERROR] comando não reconhecido");
                    
            }
            }else{
            tag ="";
                if(a.contains(":")){
                    for(int i=0;i < a.indexOf(":");i++){
                        if(a.charAt(i) == 32){
                           System.out.println("[ERROR] a tag possui espacos antes de :");
                           j = 0;
                           break;
                        }
                        else{
                            tag += a.charAt(i);
                            System.out.println(tag);
                        }
                    }
                    if(j == 1){
                    System.out.println("a tag definida e = " +tag);
                    System.out.println("e a definicao = " + a.substring(a.indexOf(":")+1));
                    }
                }
                else{
                    System.out.println("[ERROR] a tag nao possui :");
                } 
            }
            j = 1;
        }
        
    }
}
