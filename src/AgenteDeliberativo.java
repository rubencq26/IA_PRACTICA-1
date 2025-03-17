import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AgenteDeliberativo implements IAgente{
    private Percepcion percepcion;
    private int numMovimentos;
    private Laberinto laberinto;
    private int [] ubicacion;
    private boolean win;
    private boolean gameOver;

    public AgenteDeliberativo(char[][] laberin){
        laberinto = new Laberinto(laberin);
        ubicacion = new int[2];
        ubicacion[0] = 1;
        ubicacion[1] = 1;
        win = false;
        gameOver = false;
        numMovimentos = 0;
    }

    @Override
    public void mover(){
        percepcion =  new Percepcion(laberinto.getLaberintoChar());
        int movimiento = -1;
        ArrayList<Integer> movPrior = new ArrayList<>();
        ArrayList<Integer> movSec = new ArrayList<>();
        HashMap<Integer, Character> map = percepcion.percibir(ubicacion[0], ubicacion[1]);
        Random r = new Random();
        int numAleatorio;

        for(int i = 0; i < map.size(); i++){
            if(map.get(i) == 'S'){
                movimiento = i;
            }else if(map.get(i) == ' '){
                movPrior.add(i);
            }else if(map.get(i) == '.'){
                movSec.add(i);
            }
        }

        if(movimiento != -1){
            win = true;
        }else if(movPrior.size() > 0){
            numAleatorio = r.nextInt(movPrior.size());
            movimiento = movPrior.get(numAleatorio);
        } else if (movSec.size() > 0) {
            numAleatorio = r.nextInt(movSec.size());
            movimiento = movSec.get(numAleatorio);
        }else{
            gameOver = true;
        }

        switch (movimiento){
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
        }
        numMovimentos++;
        laberinto.actualizarPosicion(ubicacion[0], ubicacion[1], '.');
    }

    public int getNumMovimentos(){return numMovimentos;}

    public Percepcion getPercepcion(){return percepcion;}

    public Laberinto getLaberinto(){return laberinto;}

    public boolean isWin(){return win;}
    public boolean isGameOver(){return gameOver;}

    public int[] getUbicacion() {
        return ubicacion;
    }


}
