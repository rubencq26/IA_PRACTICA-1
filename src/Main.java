import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Laberinto maze = new Laberinto();

        int opcion = 1;
        if(opcion == 1) {
            System.out.println("Menu");
            System.out.println("1. Generar Laberinto");
            System.out.println("2. Cargar Laberinto");
            System.out.println("Elija una opcion: ");
            opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    System.out.println("Introduzca el alto: ");
                    int alto = sc.nextInt();
                    System.out.println("Introduzca el ancho: ");
                    int ancho = sc.nextInt();
                    System.out.println("Introduzca la dificultad(0-10): ");
                    int dificultad = sc.nextInt();
                    maze.generaLaberinto(alto, ancho, dificultad);
                    break;
                case 2:
                    System.out.println("Introduzca el nombre del fichero: ");
                    String archivo = sc.next();
                    maze.cargarLaberinto(archivo);
                    break;
            }
        }else{
            maze.cargarLaberinto("maze4.txt");
        }
        System.out.println("Laberinto Generado: ");
        maze.Pintar();

        AgenteReac ar1 =  new AgenteReac(maze.getLaberintoChar(), "Agente Reactivo 1");
        AgenteReac ar2 = new AgenteReac(maze.getLaberintoChar(), "Agente Reactivo 2");

        AgenteDeliberativo ad =  new AgenteDeliberativo(maze.getLaberintoChar());
        for(int i = 0; i < 1000; i++){
            ar1.mover();
            ar2.mover();
            if(ar1.isWin() || ar2.isWin()){
                break;
            }
            if(ar1.isGameOver() && ar2.isGameOver()){
                break;
            }
        }
        System.out.println("Agente Reactivo");
        if(ar1.isWin()){
            System.out.println(ar1.getNombre() + " encontro la solucion");
            System.out.println("Posicion Final: (" + ar1.getUbicacion()[0] +  ", " + ar1.getUbicacion()[1] + "), Salida en (" + maze.getSalida()[0] + ", " + maze.getSalida()[1] + ")");
            System.out.println("Solucion encontrada");
            System.out.println("Acciones: " + ar1.getNumMovimiento());
            System.out.println("Laberito recorrido");
            ar1.getLaberinto().Pintar();
        }else if(ar2.isWin()){
            System.out.println(ar2.getNombre() + " encontro la solucion");
            System.out.println("Posicion Final: (" + ar2.getUbicacion()[0] +  ", " + ar2.getUbicacion()[1] + "), Salida en (" + maze.getSalida()[0] + ", " + maze.getSalida()[1] + ")");
            System.out.println("Solucion encontrada");
            System.out.println("Acciones: " + ar2.getNumMovimiento());
            System.out.println("Laberito recorrido");
            ar2.getLaberinto().Pintar();
        }else{
            System.out.println("No se encontro la solucion");
            System.out.println("Recorrido del " + ar1.getNombre());
            ar1.getLaberinto().Pintar();

            System.out.println("Recorrido del " + ar2.getNombre());
            ar2.getLaberinto().Pintar();
        }

        System.out.println("Agente Deliberativo");
        for(int i = 0; i< 1000; i++){
            ad.mover();

            if(ad.isWin()){
                break;
            }
            if(ad.isGameOver()){
                break;
            }
        }

        System.out.println("Posicion Final: (" + ad.getUbicacion()[0] + ", " + ad.getUbicacion()[1] + ", Salida en (" + maze.getSalida()[0] + ", " + maze.getSalida()[1] + ")" );
        if(ad.isWin()){
            System.out.println("Solucion encontrada");
        }else{

            System.out.println("No se encontro la solucion");
        }
        System.out.println("Acciones: " + ad.getNumMovimentos());
        System.out.println("Laberito recorrido");
        ad.getLaberinto().Pintar();



      
    }


}