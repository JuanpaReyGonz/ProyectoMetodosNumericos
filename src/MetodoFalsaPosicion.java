import java.util.Scanner;

public class MetodoFalsaPosicion {
    public static void main(String[] args) {
        int grado_ecuacion=1;
        float x1=0, x2=0, errorAbs=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================================== MÉTODO FALSA POSICIÓN ======================================");
        System.out.println("=================================================================================================");
        System.out.println("|Método Cerrado o de Intervalo. Este método se utiliza para determinar las raíces de una función|");
        System.out.println("|Este método presenta una mejora respecto al Método de Bisección.                               |");
        System.out.println("=================================================================================================");
        System.out.print("De qué grado es tu ecuación? (2,3,4,5,...): ");
        grado_ecuacion=scanner.nextInt();
        float coeficientes[] = new float[grado_ecuacion+1];
        System.out.println("Define los coeficientes de la ecuacion:");
        for (int i = coeficientes.length - 1; i>=0; i--)
        {
            System.out.print("_x^"+i+": ");
            coeficientes[i]=scanner.nextFloat();
        }
        System.out.print("La ecuación a resolver es: ");
        for (int i = coeficientes.length - 1; i>=0 ; i--)
        {
            System.out.print(" + ("+coeficientes[i]+" x^"+i+")");
        }
        System.out.println("\nAhora define a x1 y x2");
        System.out.print("x1: ");
        x1=scanner.nextFloat();
        System.out.print("x2: ");
        x2=scanner.nextFloat();
        System.out.print("Error absoluto mínimo que detiene al método (DEFINIDO COMO PORCENTAJE (%). SOLO NÚMERO): ");
        errorAbs=scanner.nextFloat();
        //Se mandan las variables del usuario a la función que desarrolla el algoritmo de Falsa Posición
        procesoFalsaPosicion(coeficientes, x1, x2, errorAbs);
    }

    public static void procesoFalsaPosicion(float[] coeficientes, float x1, float x2, float errorAbs){
        System.out.println("======= Empieza el Desarrollo del Método Falsa Posición =======");
        int iteracion = 1;
        float xr=0, xrAnterior=0, funx1=0, funx2=0, funxr=0, errorAbsoluto=100;
        do {
            System.out.println("\nIteración "+iteracion+": ");
            //Definir la función con x1 -> f(x1)
            float funAnterior=0;
            for (int i = coeficientes.length-1; i >= 0; i--)
            {
                funAnterior= (float) (coeficientes[i]*Math.pow(x1,i));
                funx1=funx1+funAnterior;
            }

            //Definir la función con x2 -> f(x2)
            funAnterior=0;
            for (int i = coeficientes.length-1; i >= 0; i--)
            {
                funAnterior = (float) (coeficientes[i]*Math.pow(x2,i));
                funx2=funx2+funAnterior;
            }

            //Definir a xr
            xrAnterior=xr;
            xr=x2-((funx2*(x2-x1))/(funx2-funx1));

            //Definir la función con xr -> f(xr)
            funAnterior=0;
            for (int i = coeficientes.length-1; i>=0; i--)
            {
                funAnterior= (float) (coeficientes[i]*Math.pow(xr,i));
                funxr=funxr+funAnterior;
            }

            //Impresión de Lista de Datos
            System.out.print("[x1= "+x1+"] [x2= "+x2+"] [xr= "+xr+"] [f(x1): "+funx1+"] [f(x2): "+funx2+"] [f(xr): "+funxr+"] [f(x1)*f(xr): "+funx1*funxr+"] ");

            if(funxr*funx1 > 0){
                x1=xr;
            }
            if(funxr*funx1 < 0){
                x2=xr;
            }
            if(iteracion >= 2){
                errorAbsoluto=Math.abs((xr-xrAnterior)/xr)*100;
                System.out.print("[Ea(%): "+errorAbsoluto+"] ");
            }
            iteracion++; funx1=0; funx2=0; funxr=0;
        }while((errorAbs<=errorAbsoluto) && (iteracion<=50));
        System.out.println("\n==========================================================");
        System.out.println("El valor de la raíz calculada por el método de falsa posición es: {xr: "+xr+"} en la iteración: {"+(iteracion-1)+"}");
    }

}
