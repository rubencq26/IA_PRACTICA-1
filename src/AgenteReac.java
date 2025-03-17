import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;



public class AgenteReac implements  IAgente{

    private int[] ubicacion = new int[2];
    private int numMovimiento;
    private Laberinto laberinto;
    private Percepcion percepcion;
    private boolean gameOver = false;
    private boolean win = false;
    private String nombre;
    public AgenteReac(char[][] laberinto){
        numMovimiento = 0;
        ubicacion[0] = 1;
        ubicacion[1] = 1;
        this.laberinto =  new Laberinto(laberinto);
        percepcion = new Percepcion(laberinto);
        nombre = null;
    }

    public AgenteReac(char[][] laberinto, String n){
        numMovimiento = 0;
        ubicacion[0] = 1;
        ubicacion[1] = 1;
        this.laberinto =  new Laberinto(laberinto);
        percepcion = new Percepcion(laberinto);
        nombre = n;
    }

    private void guardarPosicion(){
        laberinto.actualizarPosicion(ubicacion[0],ubicacion[1], '.');
    }

    @Override
    public void mover() {
        HashMap<Integer, Character> map = percepcion.percibir(ubicacion[0], ubicacion[1]);

        ArrayList<Integer> movimientos = new ArrayList<>();
        int movimiento = -1;
        int nAleatorio;
        Random r = new Random();

        for(int i = 0; i < map.size(); i++){
            if(map.get(i) == 'S'){
                win = true;
                movimiento = i;
            }else if(map.get(i) == ' ' || map.get(i) == 'E'){
                movimientos.add(i);
            }
        }

        if(movimiento == -1 && movimientos.size() > 0){

                nAleatorio = r.nextInt(movimientos.size());
                movimiento = movimientos.get(nAleatorio);

        }

        switch(movimiento){
            case 0:
                ubicacion[1]--;
                break;
            case 1:
                ubicacion[0]--;
                break;
            case 2:
                ubicacion[1]++;
                break;
            case 3:
                ubicacion[0]++;
                break;
            default:
                gameOver = true;
                break;
        }
        numMovimiento++;
        guardarPosicion();
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public boolean isWin() {
        return win;
    }

    public int[] getUbicacion(){
        return ubicacion;
    }

    public int getNumMovimiento() {
        return numMovimiento;
    }

    public Laberinto getLaberinto() {
        return laberinto;
    }

    public String getNombre() {
        return nombre;
    }
}
