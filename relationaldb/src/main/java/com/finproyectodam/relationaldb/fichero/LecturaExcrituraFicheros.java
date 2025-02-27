package com.finproyectodam.relationaldb.fichero;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class LecturaExcrituraFicheros {

    public void escrituraUsuarioLogueado(String alias){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("alias.txt"))){
            bw.write(alias);
        }catch (IOException e){
            System.out.println("Ups, error al escribir en el archivo");
        }
    }

    public String readAliasLogueado(){
       try(BufferedReader br = new BufferedReader(new FileReader("alias.txt"))){
           return br.readLine();
       }catch(IOException e){
           System.out.println("Ups, error al leer el archivo");
       }
       return null;
    }


}
