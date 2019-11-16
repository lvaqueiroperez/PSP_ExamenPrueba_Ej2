package psp_pruebaex_2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PSP_PruebaEx_2 extends Thread {

    private String texto;
    private int vocals = 0;
    private int cons = 0;
    private int total = 0;

    private Boolean disponible1 = false;
    private Boolean disponible2 = false;

    public PSP_PruebaEx_2(String nombre, String texto) {

        super(nombre);
        this.texto = texto;

    }

    @Override
    public void run() {

        switch (getName()) {

            case "h1":

                for (int i = 0; i < texto.length(); i++) {

                    if ((texto.charAt(i) == 'a') || (texto.charAt(i) == 'e') || (texto.charAt(i) == 'i') || (texto.charAt(i) == 'o') || (texto.charAt(i) == 'u')) {

                        vocals++;

                        System.out.println("Vocales: " + vocals);

                    }

                }

                disponible1 = true;

                break;

            case "h2":

                for (int i = 0; i < texto.length(); i++) {

                    if (((texto.charAt(i) != 'a') && (texto.charAt(i) != 'e') && (texto.charAt(i) != 'i') && (texto.charAt(i) != 'o') && (texto.charAt(i) != 'u')) && Character.isLetter(texto.charAt(i))) {

                        cons++;
                        System.out.println("Consonantes: " + cons);
                    }

                }

                disponible2 = true;

                break;

            //Hace falta un tercer hilo? trabajar con synchronized??
            default:
                System.out.println("ERROR, HILO NO EXISTENTE");

        }

    }

    public static void main(String[] args) {
        //( Se confunde con los acentos )
        String texto = "Hola, que tal?";

        PSP_PruebaEx_2 h1 = new PSP_PruebaEx_2("h1", texto);
        PSP_PruebaEx_2 h2 = new PSP_PruebaEx_2("h2", texto);
        PSP_PruebaEx_2 h3 = new PSP_PruebaEx_2("h3", texto);

        h1.start();
        h2.start();
        h3.start();

    }

}
