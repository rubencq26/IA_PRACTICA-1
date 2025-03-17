//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Laberinto maze = new Laberinto();
        maze.generaLaberinto(500,500,2);
        System.out.println("Laberinto Generado: ");

        maze.Pintar();
        System.out.println("Agente Reactivo");
        AgenteReac ar2 = new AgenteReac(maze.getLaberintoChar(), "Agente 2");
        AgenteReac ar = new AgenteReac(maze.getLaberintoChar(), "Agente 1");
        for(int i = 0; i < 10000000; i++){
            ar.mover();
            ar2.mover();
            if(ar.isWin() || ar.isGameOver()|| ar2.isWin() || ar2.isGameOver() ){

                break;
            }
        }
        if(ar.isWin()){

            System.out.println(ar.getNombre() + " ha encontrado la solucion");
            System.out.println("Movimientos: " + ar.getNumMovimiento());
            System.out.println("Posicion Final: (" + ar.getUbicacion()[0] + ", " + ar.getUbicacion()[1] + ")");
            ar.getLaberinto().Pintar();

            System.out.println("Resultado " +ar2.getNombre());
            System.out.println("Movimientos: " + ar2.getNumMovimiento());
            System.out.println("Posicion Final: (" + ar2.getUbicacion()[0] + ", " + ar2.getUbicacion()[1] + ")");
            ar2.getLaberinto().Pintar();

        }else if(ar2.isWin()){
            System.out.println(ar2.getNombre() + " ha encontrado la solucion");
            System.out.println("Movimientwos: " + ar2.getNumMovimiento());
            System.out.println("Posicion Final: (" + ar2.getUbicacion()[0] + ", " + ar2.getUbicacion()[1] + ")");
            ar2.getLaberinto().Pintar();

            System.out.println("Resultado: " + ar.getNombre());
            System.out.println("Movimientos: " + ar.getNumMovimiento());
            System.out.println("Posicion Final: (" + ar.getUbicacion()[0] + ", " + ar.getUbicacion()[1] + ")");
            ar.getLaberinto().Pintar();
        }else{
            System.out.println("No se ha encontrado la solucion");
            System.out.println("Solucion: " + ar.getNombre());
            System.out.println("Movimientos: " + ar.getNumMovimiento());
            System.out.println("Posicion Final: (" + ar.getUbicacion()[0] + ", " + ar.getUbicacion()[1] + ")");
            ar.getLaberinto().Pintar();

            System.out.println("Resultado " +ar2.getNombre());
            System.out.println("Movimientos: " + ar2.getNumMovimiento());
            System.out.println("Posicion Final: (" + ar2.getUbicacion()[0] + ", " + ar2.getUbicacion()[1] + ")");
            ar2.getLaberinto().Pintar();
        }


      
    }
}