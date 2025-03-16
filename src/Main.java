//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto();
        laberinto.generaLaberinto(10,20,1);
        System.out.println();
        laberinto.Pintar();
    }
}