package com.helloworld.AhorcadoSpring.infra.console;

import com.helloworld.AhorcadoSpring.service.AhorcadoService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class ConsoleReader {
    private AhorcadoService ahorcadoService;

    public ConsoleReader(AhorcadoService ahorcadoService) {
        this.ahorcadoService = ahorcadoService;

    }


    @PostConstruct
    public void init(){
        Scanner sc = new Scanner(System.in);
        String entradaConsola;
        int opcion = 1;

        while(opcion != 2){
            System.out.println("Menú: ");
            System.out.println("1.- Juego Nuevo");
            System.out.println("2.- Salir");

            entradaConsola = sc.next();

            try{
                opcion = Integer.parseInt(entradaConsola);
            } catch(Exception e){
                System.out.println("Opción no valida,ingresa un numero");
            }
            switch(opcion){
                case 2:
                    System.out.println("Saliendo");
                    break;
                case 1:
                    ahorcadoService.nuevaPartida();
                    while(!ahorcadoService.juegoAcabado()) {
                        System.out.println(ahorcadoService.getIntentosRestantes() + " Intentos restantes");
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println(ahorcadoService.getPalabraAdivinada());

                        entradaConsola = sc.next();

                        ahorcadoService.comprobarCadena(entradaConsola);
                    }

                    if(ahorcadoService.victoriaConseguida()){
                        System.out.println("Enhorabuena lo has conseguido, la palabra era: "+ ahorcadoService.getPalabraSecreta());
                    }
                    else{
                        System.out.println("Se te acabaron los intentos, la palabra era: "+ ahorcadoService.getPalabraSecreta());
                    }

                    break;
                default:
                    System.out.println("Opcion no encontrada");
                    break;
            }

        }
    }
}
//}
