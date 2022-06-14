/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoaspectos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author PICHAU
 */
public class ManipuladorArquivo {
    public static void leitor(String path, ArrayList<String> content) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				//System.out.println(linha);

			} else
				break;
			linha = buffRead.readLine();
                        if(linha != null)
                        {
                            content.add(linha);
                        }
                        //linhaAux += linha+"\n";
		}
		buffRead.close();
                //return linhaAux;
	}

	public static void escritor(String path,String a) throws IOException {
                //String linha = leitor(path);
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		//linha += "\n"+a;
                //System.out.println(linha);
		//Scanner in = new Scanner(System.in);
		//System.out.println("Escreva algo: ");
		//linha = in.nextLine();
		buffWrite.append(a);
		buffWrite.close();
	}
    /*public static void main(String[] args) throws IOException {
        escritor("teste.txt");
        //System.out.println(leitor("teste.txt"));
    }*/
}

