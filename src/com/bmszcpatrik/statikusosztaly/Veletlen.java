package com.bmszcpatrik.statikusosztaly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Veletlen {
    private static final Random r = new Random();
    private static final List<String> VEZETEK_NEVEK = feltolt("files/veznev.txt");
    private static final List<String> NOI_KERESZTNEVEK = feltolt("files/noikernev.txt");
    private static final List<String> FERFI_KERESZTNEVEK = feltolt("files/ferfikernev.txt");
    private Veletlen(){}
    private static List<String> feltolt(String fajlnev){
        List<String> lista = new ArrayList<>();
        try{
            Scanner file = new Scanner(new File(fajlnev));
            while(file.hasNext()){
                lista.add(file.nextLine());
            }
            file.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return lista;
    }
    public static int velEgesz(int min, int max){
        if (min > max){
            throw new IllegalArgumentException("'min' must be lower than 'max'");
        }
        return r.nextInt(max - min + 1) + min;
    }
    public static char velKarakter(char min, char max){
        return (char)velEgesz(min, max);
    }
}