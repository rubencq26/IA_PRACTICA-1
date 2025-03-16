import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Laberinto {
    private int alto;
    private int ancho;
    private char[][] laberintoChar; //array bidimensional de char para crear un laberinto por cordenadas
    private Random rand;

    //Constructor
    public Laberinto() {
        laberintoChar = null;
        rand = new Random();
    }

    public int getAlto() {
        return alto;
    }
    public int getAncho() {
        return ancho;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void generaLaberinto(int alto, int ancho,int dificultad) {
        this.alto = alto;
        this.ancho = ancho;
        this.laberintoChar = new char[alto][ancho];
        for(int i = 0;i < this.alto;i++) {
            for(int j = 0;j < this.ancho;j++) {
                if(i == 0 || i == this.alto -1 || j == 0 || j == this.ancho - 1) {
                    laberintoChar[i][j] = '#';
                }else{
                    int numAleatorio = rand.nextInt(10);
                    if(numAleatorio < dificultad){
                        laberintoChar[i][j] = '#';
                    }else{
                        laberintoChar[i][j] = ' ';
                    }

                }

            }
            laberintoChar[1][1] = 'E';
            laberintoChar[alto - 2][ancho - 2] = 'S';
        }
    }

    public void Pintar(){
        for(int i = 0; i < this.alto; i++) {
            for(int j = 0; j <= this.ancho; j++) {
                if(j == this.ancho) {
                    System.out.print('\n');
                }else{
                    System.out.print(laberintoChar[i][j]);
                }

            }
        }

    }

    public boolean esVacio(){
        if(laberintoChar == null){
            return true;
        }
        return false;
    }

    public char[][] getLaberintoChar() {
        return laberintoChar;
    }
}
