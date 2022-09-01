/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pilasejemplo;

import java.util.Scanner;

/**
 *
 * @author patog
 */
public class PilasEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pila miPila = new Pila();
        int dia = 1;
        int diaSemana = 1;
        int contadorSurtir = 1;
        int contadorLunes = 1;
        char c;
        int ganancias = 0;

            
        Pila pilaInvertida = new Pila();
        Pila pilaDos = new Pila();
        
        pilaDos.Push('A', 1, 1);
        pilaDos.Push('B', 1, 2);
        pilaDos.Push('C', 1, 3);
        pilaDos.Push('D', 1, 4);
        pilaDos.Push('E', 1, 5);
        
        
        //refrescos iniciales
        miPila.Push('L', 1, 1);
        miPila.Push('L', 1, 2);
        miPila.Push('L', 1, 3);
        miPila.Push('L', 1, 4);
        miPila.Push('L', 1, 5);
        
        
        
        //loop para simular
        do {

            boolean bandera;
            
              //reiniciar contador de lunes cuando el dia llegue a lunes
              //(que se reinicie la semana)
            if (diaSemana == 8) {
                diaSemana = 1;
            }
            
            //imprimir cual es el dia de la semana + dia del mes
            //el dia le corresponde de acuerdo a su representacion numerica en la semana (1 a 7)
            switch (diaSemana) {
                case 1:
                    System.out.println("LUNES " + dia);
                    break;
                case 2:
                    System.out.println("MARTES " + dia);
                    break;
                case 3:
                    System.out.println("MIERCOLES " + dia);
                    break;
                case 4:
                    System.out.println("JUEVES " + dia);
                    break;
                case 5:
                    System.out.println("VIERNES " + dia);
                    break;
                case 6:
                    System.out.println("SABADO " + dia);
                    break;
                case 7:
                    System.out.println("DOMINGO " + dia);
                    break;
            }

            //no surtir los lunes
            if (contadorSurtir == 2 && diaSemana == 1) {
                System.out.println("LUNES NO RESURTE");
                contadorSurtir =0;
            } //surtir cada 2 dias (y que no sea lunes)
            else if (contadorSurtir == 2) {
               miPila.resurtir(diaSemana, dia, miPila);
                contadorSurtir = 0; //r
            }
            
            //simular venta cada dia
            int x = miPila.VentaAleatoria(miPila, dia);
            
            //calcular las ganancias de acuerdo a cuantos refrescos se vendieron
            if (x == 5){
            ganancias = ganancias +5;
            }
            else if (x == 10){
            ganancias = ganancias +10;
            }
            else if (x == 15){
            ganancias = ganancias +15;
            }
            else if (x== 20){
            ganancias = ganancias +20;
            }
            
            
            //pasar al proximo dia
            contadorSurtir++;
            contadorLunes++;
            diaSemana++;
            dia++;

            System.out.println("------------------------");
            System.out.println("DESEA REALIZAR OTRA ACCION? S = Si");
            c = sc.next().charAt(0);

        } while (dia != 32 ||c != 's'); //jair tmb no se si puedas arreglar esto:
                                         //el programa se sigue ejecutando aunq le presiones la tecla
                                         //para q pare
        
        System.out.println("GANANCIAS:" + ganancias);
        int totalVendidos = ganancias/5; //cuantos refrescos se vendieron
        System.out.println("REFRESCOS VENDIDOS:" + totalVendidos);
    }

}
