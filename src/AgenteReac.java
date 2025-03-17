import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.List;
import java.util.HashMap;

public class AgenteReac implements  IAgente{

    private int[] ubicacion = new int[2];
    private int numMovimiento;
    private char[][] laberinto;
    Percepcion percepcion;

    public AgenteReac(char[][] laberinto){
        numMovimiento = 0;
        ubicacion[0] = 0;
        ubicacion[1] = 0;
        this.laberinto = laberinto;
        Percepcion per = new Percepcion(laberinto);
    }

    private void guardarPosicion(){
        if(laberinto[ubicacion[0]][ubicacion[1]] != 'E' || laberinto[ubicacion[0]][ubicacion[1]] != 'S' || laberinto[ubicacion[0]][ubicacion[1]] !='#'){
            laberinto[ubicacion[0]][ubicacion[1]]='.';
        }
    }

    @Override
    public int mover(HashMap<Integer,Character> mapa) {

    }



    public int getNumMovimiento() {
        return numMovimiento;
    }
}
