package com.rvmarra17.calculaletradni.core;

public class calcularLetraDNI {

    private static final String ALFABETO = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static char calcula(int dni){
        return ALFABETO.charAt(dni%ALFABETO.length());
    }

   public static char calcula (String dni){
        return calcula(Integer.parseInt(dni));
    }
}
