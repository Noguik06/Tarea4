/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juannoguera
 */
public class Test1 {
    
    public Test1() {
        
    }
    
    @Test
     public void PruebaListas() throws IOException {
         
         String prueba = "";
         assertTrue("La lista no puede estar vacia", true);
         LinkedList lista = getLista("lista1.txt");
         assertTrue("La lista 1 no puede estar vacia", lista.size() > 1);
         lista = getLista("lista2.txt");
         assertTrue("La lista 2 no puede estar vacia", lista.size() > 1);
     }
     
    //Metodo para leer lineas de codigo
    public static LinkedList getLista(String fileName) throws FileNotFoundException, IOException {
        LinkedList lista = new LinkedList();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                lista.add(line);
            }
        }
        return lista;
    }
}
