package com.helloworld.AhorcadoSpring.repository.impl;

import com.helloworld.AhorcadoSpring.repository.PalabrasRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PalabrasRepositoryMemory implements PalabrasRepository {

    List<String> palabras;
    public PalabrasRepositoryMemory(){
        this.palabras = new ArrayList<>();
        palabras.add("negocio");
        palabras.add("tribu");
        palabras.add("viajes");
        palabras.add("timbre");
        palabras.add("esculpir");
        palabras.add("despedida");
        palabras.add("regalos");
        palabras.add("azulejo");
        palabras.add("cereal");
        palabras.add("estanque");

    }
    @Override
    public String elegirPalabraSecreta() {
        int numero = (int)(Math.random()*10);
        return palabras.get(numero);
    }
}
