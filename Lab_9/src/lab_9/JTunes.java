/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_9;

import javax.swing.ImageIcon;

/**
 *
 * @author esteb
 */

public class JTunes {
    private Song[] canciones;
    
    public JTunes(int tamaño){
        this.canciones = new Song[tamaño];
    }
    
    public boolean addSong(int codigo, String nombre, double precio, ImageIcon imagenDisco){
        if(searchSong(codigo) != null){
            return false;
        }
        
        for(int i=0; i< canciones.length; i++){
            if(canciones[i] == null){
                canciones[i]= new Song(codigo, nombre, precio, imagenDisco);
                return true;
            }
        }
        return false;
    }
    
    public Song searchSong(int codigo){
        for(Song cancion : canciones){
            if(cancion != null && cancion.getCodigo() ==  codigo){
                return cancion;
            }
        }
        return null;
    }
    
    public void rateSong(int codigo, int stars){
        Song cancion = searchSong(codigo);
        if(cancion != null){
            cancion.addStars(stars);
        }
    }
    
    public Song[] getAllSongs(){
        int count = 0;
        for(Song cancion: canciones){
            if(cancion!=null){
                count++;
            }
        }
        Song[] cancionesExistentes = new Song[count];
        int index = 0;
        for(Song cancion : canciones){
            if(cancion != null){
                cancionesExistentes[index++] = cancion;
            }
        }
        return  cancionesExistentes;
    }
}
