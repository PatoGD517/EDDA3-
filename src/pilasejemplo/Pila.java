/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasejemplo;

/**
 *
 * @author patog
 */
public class Pila {

    private NodoPila top;

    public NodoPila getTop() {
        return top;
    }
    private int tamanio;

    public int getTamanio() {
        return tamanio;
    }

    public Pila() {
        this.top = null;
        this.tamanio = 0;

    }
    
    public boolean isEmpty() {
        return this.top == null;
    }

    public void Push(char dia, int diaNum, int unidad) {
        if (tamanio <= 6) { //6 es el maximo de refrescos que puede haber
            NodoPila nuevo = new NodoPila(dia, diaNum, unidad);
            nuevo.nodoAbajo = top;
            top = nuevo;
            tamanio++;
        } else {
            System.out.println("REFIGERADOR LLENO");
        }

    }

    public char Pop() { //sacar el refresco de mero arriba
        if (tamanio == 0) {
            System.out.println("PILA VACIA");
            return 0;
        } else {
            char elemento = top.dato;
            System.out.println("REFRESCO VENDIDO:" + top.dato + top.dato2 + top.dato3);
            top = top.nodoAbajo;
            tamanio--;
            return elemento;
        }
    }

    public void MostrarPila() { //imprimir pila
        if (tamanio == 0) {
            System.out.println("PILA VACIA");
        } else {
            NodoPila recorrer = top;
            while (recorrer != null) {
                System.out.println(recorrer.dato + "" + recorrer.dato2 + "" + recorrer.dato3);
                recorrer = recorrer.nodoAbajo;
            }

        }
    }
    
    public void MostrarPilaConDias(int dia) { //imprimir pila
        if (tamanio == 0) {
            System.out.println("PILA VACIA");
        } else {
            NodoPila recorrer = top;
            while (recorrer != null) {
                int diasExistiendo = dia - recorrer.dato2;
                System.out.println(recorrer.dato + "" + recorrer.dato2 + "" + recorrer.dato3 + " -- lleva " + diasExistiendo + " dias existiendo");
                recorrer = recorrer.nodoAbajo;
            }

        }
    }

    //resurtir de acuerdo al dia (lunes,martes,etc.)
    public void resurtir(int dia, int dia2, Pila pila) {

        switch (dia) {
            case 1:
                int limite;
                limite = 7 - tamanio;
                for (int i = 1; i < limite; i++) {
                    pila.Push('L', dia2, i);
                }
                System.out.println("RESURTIDO");
                pila.MostrarPila();
                break;
            case 2:
                limite = 7 - tamanio;
                for (int i = 1; i < limite; i++) {
                    pila.Push('M', dia2, i);
                }
                System.out.println("RESURTIDO");
                pila.MostrarPila();
                break;
            case 3:
                limite = 7 - tamanio;
                for (int i = 1; i < limite; i++) {
                    pila.Push('X', dia2, i);
                }
                System.out.println("RESURTIDO");
                pila.MostrarPila();
                break;
            case 4:
                limite = 7 - tamanio;
                for (int i = 1; i < limite; i++) {
                    pila.Push('J', dia2, i);
                }
                System.out.println("RESURTIDO");
                pila.MostrarPila();
                break;
            case 5:
                limite = 7 - tamanio;
                for (int i = 1; i < limite; i++) {
                    pila.Push('V', dia2, i);
                }
                System.out.println("RESURTIDO");
                pila.MostrarPila();
                break;
            case 6:
                limite = 7 - tamanio;
                for (int i = 1; i < limite; i++) {
                    pila.Push('S', dia2, i);
                }
                System.out.println("RESURTIDO");
                pila.MostrarPila();
                break;
            case 7:
                limite = 7 - tamanio;
                for (int i = 1; i < limite; i++) {
                    pila.Push('D', dia2, i);
                }
                System.out.println("RESURTIDO");
                pila.MostrarPila();
                break;

        }
    }

    public int VentaAleatoria(Pila pila, int dia) { //VENTA ALEATORIA DE REFRESCOS 

        if (tamanio == 0) {
            System.out.println("NO HAY REFRESCOS DISPONIBLES"); //se acabaron los refrescos
        } else {

            int azarV = 1 + (int) (Math.random() * ((4 - 1) + 1)); //generar un numero al azar del 1 al 4

            if (azarV > tamanio) {
                azarV = tamanio - azarV; //condicional para no vender refrescos que no existan
            }

            switch (azarV) {
                case 1:
                    System.out.println("NINGUNA VENTA");
                    System.out.println("INVENTARIO AL FINAL DEL DIA");
                    pila.MostrarPilaConDias(dia);
                    return 0;
                case 2:
                    System.out.println("VENTA 2 REFRESCOS");
                    pila.Pop();
                    pila.Pop();
                    System.out.println("INVENTARIO POST VENTA:");
                    pila.MostrarPilaConDias(dia);
                    return 10;
                case 3:
                    System.out.println("VENTA 3 REFRESCOS");
                    pila.Pop();
                    pila.Pop();
                    pila.Pop();
                    System.out.println("INVENTARIO POST VENTA:");
                    pila.MostrarPilaConDias(dia);
                    return 15;
                case 4:
                    System.out.println("VENTA 4 REFRESCOS");
                    pila.Pop();
                    pila.Pop();
                    pila.Pop();
                    pila.Pop();
                    System.out.println("INVENTARIO POST VENTA:");
                    pila.MostrarPilaConDias(dia);
                    return 20;

            }
        }
        return 0;
    }
     
    public Pila invertir() {
        Pila invertida = new Pila();
        NodoPila temp = top;
        
        while (temp != null) {
            invertida.Push(temp.dato, temp.dato2, temp.dato3);
            temp = temp.nodoAbajo;
        }
        
        return invertida;
    } 
    
    public Pila alternar(Pila pila2) {
        // abcde
        // 12345
        // a1b2c3d4e5
        Pila alternada = new Pila();
        NodoPila temp1 = this.getTop();
        NodoPila temp2 = pila2.getTop();
        
        if (this.getTamanio() != pila2.getTamanio()) {
            // no se puede
            return null;
        }
        
        for (int i = 0; i < pila2.getTamanio(); i++) {
            alternada.Push(temp1.dato, temp1.dato2, temp1.dato3);
            alternada.Push(temp2.dato, temp2.dato2, temp2.dato3);
            temp1 = temp1.nodoAbajo;
            temp2 = temp2.nodoAbajo;
        }
        
        return alternada;
    }

}
