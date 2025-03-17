import java.util.HashMap;

public class Percepcion {
    private HashMap<Integer,Character> percepcion; //0=izquierda ; 1=arriba ; 2=derecha ; 3=abajo
    private char laberinto[][];
    public Percepcion(char[][] laberinto) {
        this.laberinto = new char[laberinto.length][laberinto[0].length];

        for (int i = 0; i < laberinto.length; i++) {
            this.laberinto[i] = laberinto[i].clone(); // Copia cada fila de la matriz
        }
    }

    public void actualizarLaberinto(char[][] laberinto) {
        this.laberinto = laberinto;
    }
    public HashMap<Integer,Character> percibir(int i, int j) {
        percepcion = new HashMap<>();
        percepcion.put(0,laberinto[i][j-1]);//izquierda
        percepcion.put(1, laberinto[i-1][j]);//arriba
        percepcion.put(2, laberinto[i][j+1]);//derecha
        percepcion.put(3, laberinto[i+1][j]);//abajo
        return percepcion;
    }

}
