import java.io.*;
import java.io.BufferedReader;
import java.util.Random;
import java.util.ArrayList;

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

    public Laberinto(char[][] laberintoChar) {
        actualizarLaberinto(laberintoChar);
        rand = new Random();
    }

    public void actualizarPosicion(int x, int y, char signo ) {
        if(laberintoChar[x][y] != 'E' && laberintoChar[x][y] != 'S') {
            laberintoChar[x][y] = signo;
        }

    }

    public void actualizarLaberinto(char[][] laberinto) {
        this.alto = laberinto.length;
        this.ancho = laberinto[0].length;
        this.laberintoChar = new char[alto][ancho];

        for (int i = 0; i < alto; i++) {
            this.laberintoChar[i] = laberinto[i].clone(); // Copia profunda del array
        }
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

        }
        laberintoChar[1][1] = 'E';
        laberintoChar[alto - 2][ancho - 2] = 'S';
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

    public void almacenarLaberinto(String nombreArchivo) {
        String linea;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))){
            for(int i = 0; i < this.alto; i++) {
                linea = new String();
                linea = "";
                for(int j = 0; j < this.ancho; j++) {
                    linea = linea + laberintoChar[i][j];
                }
                writer.write(linea);
                writer.newLine();
            }
            System.out.println("Archivo almacenado correctamente");
        }catch (IOException e){
            System.out.println("Ocurrio un error al escribir el archivo");
            e.printStackTrace();
        }
    }

    public void cargarLaberinto(String nombreArchivo) {
        ArrayList<String> matriz = new ArrayList<>();
        String linea;
        try(BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))){
            while ((linea = reader.readLine()) != null){
                matriz.add(linea);
            }

            linea = matriz.get(0);
            this.alto = matriz.size();
            this.ancho = linea.length();
            laberintoChar = new char[alto][ancho];

            for(int i = 0;i < matriz.size();i++) {
                linea = matriz.get(i);
                for(int j = 0;j < linea.length();j++) {

                    laberintoChar[i][j] = linea.charAt(j);
                }
            }
            System.out.println("Archivo cargado correctamente");
        }catch ( IOException e){
            System.out.println("Ocurrio un error al escribir el archivo");
            e.printStackTrace();
        }
    }
}
