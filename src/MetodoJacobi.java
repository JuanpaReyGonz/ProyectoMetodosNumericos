import java.util.Scanner;

public class MetodoJacobi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float errorAbs=0;
        /*float matriz[][] = new float[3][4];
        System.out.println("======================================== MÉTODO JACOBI ==========================================");
        System.out.println("=================================================================================================");
        System.out.println("|Método Iterativo para resolver sistemas de ecuaciones lineales.                                |");
        System.out.println("=================================================================================================");
        System.out.println("Ingresar los coeficientes de las 3 ecuaciones lineales: ");
        for (int i = 0; i<=2; i++) {
            System.out.println("Ecuacion "+(i+1)+". ");
            for (int j = 0; j <= 3; j++) {
                if(j<=2) {
                    System.out.print("_x" + (j + 1) + ": ");
                    matriz[i][j] = scanner.nextFloat();

                }
                else{
                    System.out.print("Term.Indep: ");
                    matriz[i][j] = scanner.nextFloat();
                }
            }
            System.out.println("============================");
        }
        imprimirMatriz(matriz);*/
        float [][] matriz = {{2,5,2,3},{4,-1,1,8},{1,2,4,11}};
        ordenarMatriz(matriz);
        System.out.println("Matriz Ordenada");
        imprimirMatriz(matriz);

        procesoJacobi(matriz, (float) 0, (float) 0, (float) 0, (float) 0.1);
    }

    public static void  imprimirMatriz(float[][] matriz){
        for (int i=0; i<=2; i++){
                System.out.println("["+matriz[i][0]+" x1] "+"["+matriz[i][1]+" x2] "+"["+matriz[i][2]+" x3] = "+matriz[i][3]);
        }
    }

    public static void ordenarMatriz(float[][] matriz){
        float x1[]= new float[4], temporal[] = new float[4];
        if(matriz[1][0] >= matriz[0][0] && matriz[1][0] >= matriz[2][0]){
            for (int i = 0; i<4; i++){
                //Almacenar valores
                x1[i]=matriz[1][i];
                //Respaldo información de [0][0]
                temporal[i]=matriz[0][i];
            }
            //Switcheamos los lugares
            for (int i=0; i<4; i++){
                matriz[0][i]=x1[i];
                matriz[1][i]=temporal[i];
            }
            System.out.println("Soy matriz 2");
            imprimirMatriz(matriz);
        }
        else if(matriz[2][0] >= matriz[0][0] && matriz[2][0] >= matriz[1][0]){
            for (int i = 0; i<4; i++){
                //Almacenar valores
                x1[i]=matriz[2][i];
                //Respaldo información de [0][0]
                temporal[i]=matriz[0][i];
            }
            //Switcheamos los lugares
            for (int i=0; i<4; i++){
                matriz[0][i]=x1[i];
                matriz[2][i]=temporal[i];
            }
            System.out.println("Soy matriz 3");
            imprimirMatriz(matriz);
        }
        //Obtener 2da coeficiente sin tomar en cuenta al [0][1]
        if(matriz[2][1] >= matriz[1][1]){
            for (int i = 0; i<4; i++){
                //Almacenar valores
                x1[i]=matriz[2][i];
                //Respaldo información de [0][0]
                temporal[i]=matriz[1][i];
            }
            //Switcheamos los lugares
            for (int i=0; i<4; i++){
                matriz[1][i]=x1[i];
                matriz[2][i]=temporal[i];
            }
        }
    }

    public static void procesoJacobi(float[][] matriz, float valorInicial1, float valorInicial2, float valorInicial3, float errorAbs){
        //Despejar a x1, x2, x3
        System.out.println("Ecuaciones despejadas: ");
        System.out.println("x1= [("+matriz[0][3]+") - ("+matriz[0][1]+") - ("+matriz[0][2]+")]/"+matriz[0][0]);
        System.out.println("x2= [("+matriz[1][3]+") - ("+matriz[1][0]+") - ("+matriz[1][2]+")]/"+matriz[1][1]);
        System.out.println("x3= [("+matriz[2][3]+") - ("+matriz[2][0]+") - ("+matriz[2][1]+")]/"+matriz[2][2]);
        float despejex1=0, despejex2=0, despejex3=0;
        int iteracion=1;
        do{
            System.out.println("Iteración "+iteracion+": ");
            despejex1=(matriz[0][3]-(valorInicial2*matriz[0][1])-(valorInicial3*matriz[0][2]))/matriz[0][0];
            despejex2=(matriz[1][3]-valorInicial1*matriz[1][0]-valorInicial3*matriz[1][2])/matriz[1][1];
            despejex3=(matriz[2][3]-valorInicial1*matriz[2][0]-valorInicial2*matriz[2][1])/matriz[2][2];

            System.out.println("[x1(k): "+valorInicial1+"] [x2(k): "+valorInicial2+"] [x3(k): "+valorInicial3+"] [x1(k+1): "+despejex1
            +"] [x2(k+1): "+despejex2+"] [x3(k+1): "+despejex3+"]");

            valorInicial1=despejex1;
            valorInicial2=despejex2;
            valorInicial3=despejex3;
            iteracion++;
        }while(iteracion<=20);


    }

}
