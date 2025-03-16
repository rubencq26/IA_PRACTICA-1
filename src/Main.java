//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto();
        laberinto.generaLaberinto(10,17,3);
        System.out.println();
        laberinto.Pintar();
        laberinto.almacenarLaberinto("maze4.txt");
    }
}