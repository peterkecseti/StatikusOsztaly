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
    public static String velVezeteknev(){
        return VEZETEK_NEVEK.get(r.nextInt(VEZETEK_NEVEK.size()));
    }

    /**
     * Véletlen keresztnevet generál a megadott paraméterek alapján.
     * Paraméter értékétől függően férfi vagy női keresztnevet.
     * @param nem A generált név neme. Férfi ha igaz (true), nő ha hamis (false).
     * @return Generált keresztnév.
     */
    public static String velKeresztnev(boolean nem){
        String keresztNev;
        if (nem){
         keresztNev = velFerfiKeresztnev();
        }else{
        keresztNev = velNoiKeresztnev();
        }
        return keresztNev;
    }
    private static String velNoiKeresztnev() {
    return NOI_KERESZTNEVEK.get(r.nextInt(NOI_KERESZTNEVEK.size()));
    }
    private static String velFerfiKeresztnev() {
    return FERFI_KERESZTNEVEK.get(r.nextInt(FERFI_KERESZTNEVEK.size()));
    }
    /**
     * Véletlen nevet generál a megadott paraméterek alapján.
     * Paraméter értékétől függően férfi vagy női keresztnevet.
     * @param nem A generált név neme. Férfi ha igaz (true), nő ha hamis (false).
     * @return Generált teljes név.
     */
    public static String velTeljesNev(boolean nem){
        return velVezeteknev() + " " + velKeresztnev(nem);
    }

}