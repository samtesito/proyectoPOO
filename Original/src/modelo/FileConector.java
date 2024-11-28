/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author apari
 */
public class FileConector {
    private String readFile(String PathFile){
        try{
            Path fileName = Path.of(PathFile);
            String str = Files.readString(fileName);
            return str;
        }catch (IOException ex) {
            System.out.print("Invalid Path");
            return null;
        }
    }
    
    private void writeFile(String PathFile, String Content){
        try {            
            Path fileName = Path.of(PathFile);
            Files.writeString(fileName, Content,StandardCharsets.UTF_8);
        }
        catch (IOException ex) {
            System.out.print("Invalid Path");
        }
    }
    
    
    public String readFPregunta(){
        return readFile("BD/fPregunta.json");
    }
    public void writeFPregunta( String Content){
        writeFile("BD/fPregunta.json",Content);
    }
}
