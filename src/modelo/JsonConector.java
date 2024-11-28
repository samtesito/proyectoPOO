/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

 import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author apari
 */
public class JsonConector<T> {
    public ArrayList<T> ReadJson( String fText){
        Gson json = new Gson();
        ArrayList<T> nObject = new ArrayList<T>();
        nObject.addAll(json.fromJson(fText, ArrayList.class));
        return nObject;
    }
    
    public String WriteJson(List<T> rObject){
        Gson json = new Gson();
        return json.toJson(rObject, List.class);
    }
}
