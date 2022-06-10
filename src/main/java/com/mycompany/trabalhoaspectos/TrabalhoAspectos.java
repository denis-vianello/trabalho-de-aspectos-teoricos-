/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.trabalhoaspectos;

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
        String[] div;
        String tag;
        String content;
        //System.out.println(tag);
        //System.out.println(content);
        int x = 1;
        while(x == 1){
            a = teclado.next();
            System.out.println(a); //checagem da string TIRA ISSO!!!!
            if(a.contains(" ")){
                div = a.split(" ");
                tag = div[0];
                content = div[1];
            }else{
                tag = a;
            }
            switch(tag){
                case ":d" :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                case ":c" :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                case ":o" :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                case ":p" :{
                    //System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                case ":a" :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                case ":l" :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                case ":q" :{
                    x=0;
                    break;
                }
                case ":s" :{
                    System.out.println("[WARNING] funcao nao implementada");
                    break;
                }
                default:
                    System.out.println("ERRO");
                    
            }
            
        }
        
    }
}
