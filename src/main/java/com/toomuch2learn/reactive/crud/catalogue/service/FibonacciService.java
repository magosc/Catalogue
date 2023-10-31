package com.toomuch2learn.reactive.crud.catalogue.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    public String fibonacci(String posicion){
        String respuesta = "";

        int num1 = 0, num2 = 1, suma = 1;
        int po = Integer.parseInt(posicion);

        for (int i = 1; i<=po; i++){
            respuesta = respuesta + "" + suma + ",";

            suma = num1 + num2;
            num1 = num2;
            num2 = suma;
        }

        return respuesta;
    }
}
