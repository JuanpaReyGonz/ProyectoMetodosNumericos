import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int opcion;
        //do {

            System.out.println("========================= PROYECTO METODOS NUMERICOS =========================");
            System.out.println("|Alumno: Juan Pablo Reyes González - REG. 20310236 - 5to - Plantel Colomos    ");
            System.out.println("==============================================================================");

            System.out.println("Selecciona una opción en el menú: ");
            System.out.println("1. U2-Método Biseccion.");
            System.out.println("2. U2-Método Falsa Posición");
            System.out.println("3. U3-Metodo Jacobi");
            System.out.println("4. U4-Metodo Minimos Cuadrados para Ajuste de Lienas Rectas");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    MetodoBiseccion objetoBiseccion = new MetodoBiseccion();
                    objetoBiseccion.main();
                    break;
                case 2:
                    MetodoFalsaPosicion objetoFalsaPos = new MetodoFalsaPosicion();
                    objetoFalsaPos.main();
                    break;
                case 3:
                    MetodoJacobi objetoJacobi = new MetodoJacobi();
                    objetoJacobi.main();
                    break;
                case 4:
                    MetodoMinimosCuadradosAjusteLineasRectas objetoMinCuad = new MetodoMinimosCuadradosAjusteLineasRectas();
                    objetoMinCuad.main();
            }



        //}while()
    }
}
