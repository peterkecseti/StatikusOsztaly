package com.bmszcpatrik.statikusosztaly;

public class Main {
    public static void main(String[] args) {
        // Math objektum = new Math();
        for (int i = 0; i < 100; i++) {
            System.out.println(Veletlen.velEgesz(5, 10));
        }
        System.out.println("--------------------------------------");
        for (int i = 0; i < 100; i++) {
            System.out.println(Veletlen.velKarakter((char)'A', (char)'Z'));
        }
        System.out.println("--------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println(Veletlen.velTeljesNev(true));
            System.out.println(Veletlen.velTeljesNev(false));
        }
    }
}
