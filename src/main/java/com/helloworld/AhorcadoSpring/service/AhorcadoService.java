package com.helloworld.AhorcadoSpring.service;

public interface AhorcadoService {
    void comprobarCadena(String cadena);
    void nuevaPartida();
    boolean juegoAcabado();
    int getIntentosRestantes();
    String getPalabraAdivinada();
    boolean victoriaConseguida();
    String getPalabraSecreta();
}
