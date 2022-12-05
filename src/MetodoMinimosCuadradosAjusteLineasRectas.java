import java.util.Scanner;

public class MetodoMinimosCuadradosAjusteLineasRectas {
    public void main() {
    Scanner scanner = new Scanner(System.in);
    int puntos = 0;
        System.out.println("===================== MÉTODO DE MINIMOS CUADRADOS PARA AJUSTE DE LINEA RECTA ====================");
        System.out.println("=================================================================================================");
        System.out.println("|Método para ajustar la función de una línea recta a partir de puntos.                           |");
        System.out.println("=================================================================================================");
        System.out.print("Cuántos puntos de << x,y >> tienes?: ");
    puntos =scanner.nextInt();

    float puntosx[] = new float[puntos];
    float puntosy[] = new float[puntos];
        System.out.println("=======================");
        System.out.println("Define los puntos de x");
        for(
    int i = 0;
    i<puntos;i++)

    {
        System.out.print("x" + (i + 1) + ": ");
        puntosx[i] = scanner.nextFloat();
    }
        System.out.println("============================");
        System.out.println("Ahora define los puntos de y");
        for(
    int i = 0;
    i<puntos;i++)

    {
        System.out.print("y" + (i + 1) + ": ");
        puntosy[i] = scanner.nextFloat();
    }

    procesoMinCuadrados(puntos, puntosx, puntosy);

    }

    public static void procesoMinCuadrados(int puntos, float[] puntosx, float[] puntosy){
        //Definir xi*yi, sumatoriaxi, sumatoriayi, sumatoriax al cuadrado
        float xiyi=0, sumxi=0, sumyi=0, sumxCuadrada=0;
        for (int i=0; i<puntos; i++){
            xiyi=puntosx[i]*puntosy[i]+xiyi;
            sumxi=puntosx[i]+sumxi;
            sumyi=puntosy[i]+sumyi;
            sumxCuadrada= (float) (Math.pow(puntosx[i],2)+sumxCuadrada);
        }
        //Definir media de x y media de y para la variable a0
        float promx=0, promy=0;
        promx=sumxi/puntos;
        promy=sumyi/puntos;
        //Definir a1 y a0
        float a0=0, a1=0;
        a1 = (float) ((puntos*xiyi-sumxi*sumyi)/(puntos*sumxCuadrada-(Math.pow(sumxi,2))));
        a0 = promy-a1*promx;

        System.out.println("El ajuste de la función de la recta por mínimos cuadrados es: y = ["+ a0 +"] + ["+a1+"x]");

        float st=0, sr=0, sy=0, syx=0, r=0;
        for (int i=0; i<puntos; i++){
            st=((puntosy[i]-sumyi/puntos)*(puntosy[i]-sumyi/puntos))+st;
            sr=((puntosy[i]-a0-a1*puntosx[i])*(puntosy[i]-a0-a1*puntosx[i]))+sr;
        }
        sy = (float) Math.sqrt(st/(puntos-1));
        syx = (float) Math.sqrt(sr/(puntos-2));
        r = (st-sr)/st;
        System.out.println("Sy = "+sy);
        System.out.println("Sy/x = "+syx);
        System.out.println("r² = "+r);
    }
}
