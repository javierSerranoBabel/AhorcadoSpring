package com.helloworld.AhorcadoSpring.service.impl;

import com.helloworld.AhorcadoSpring.repository.PalabrasRepository;
import com.helloworld.AhorcadoSpring.service.AhorcadoService;
import org.springframework.stereotype.Service;



@Service
public class AhorcadoServiceImpl implements AhorcadoService {
    private String palabraSecreta;
    private String palabraAdivinada;
    private PalabrasRepository palabrasRepository;
    private boolean victoria = false;
    private int intentos = 0;
    private final int MAX_INTENTOS = 8;


    public AhorcadoServiceImpl(PalabrasRepository palabrasRepository){
        this.palabrasRepository = palabrasRepository;

    }

    @Override
    public void nuevaPartida(){
        palabraSecreta = palabrasRepository.elegirPalabraSecreta();
        palabraAdivinada = ocultarPalabra(palabraSecreta);
        intentos = 0;
        victoria = false;
    }


    @Override
    public void comprobarCadena(String cadena) {
        if(cadena.length() == 1){
            comprobarLetra(cadena.toLowerCase());
        }
        else{
            comprobarPalabra(cadena.toLowerCase());
        }


        if(palabraSecreta.equals(palabraAdivinada)){
            victoria = true;
        }

    }
    private void comprobarLetra(String cadena){
        char letra = cadena.charAt(0);
        char[] palabraAdivinadaActualizada= palabraAdivinada.toCharArray();
        if(palabraSecreta.contains(cadena) && !palabraAdivinada.contains(cadena)){
            for(int i = 0; i < palabraAdivinada.length();i++){
                if(palabraSecreta.charAt(i) == letra){
                    palabraAdivinadaActualizada[i] = letra;
                }
            }
            palabraAdivinada = new String(palabraAdivinadaActualizada);
        }
        else{
            intentos++;
        }

    }
    private void comprobarPalabra(String cadena){
        if(palabraSecreta.equals(cadena)){
            palabraAdivinada = palabraSecreta;

        }
        else{
            intentos++;
        }

    }

    private String ocultarPalabra(String palabra){
        String palabraSecreta="";
        for(int i = 0; i < palabra.length();i++){
            palabraSecreta += "_";
        }
        return palabraSecreta;
    }

    @Override
    public boolean juegoAcabado(){
        return (intentos >= MAX_INTENTOS) || (palabraSecreta.equals(palabraAdivinada));
    }

    @Override
    public boolean victoriaConseguida(){
        return victoria;
    }

    @Override
    public int getIntentosRestantes(){
        return MAX_INTENTOS - intentos;
    }

    @Override
    public String getPalabraAdivinada(){
        return palabraAdivinada;

    }

    @Override
    public String getPalabraSecreta(){
        return palabraSecreta;
    }


}
