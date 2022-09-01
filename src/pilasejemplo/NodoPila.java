/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasejemplo;

/**
 *
 * @author patog
 */
public class NodoPila {
    public char dato;
    public int dato2;
    public int dato3;
    public NodoPila nodoAbajo;
    
    public NodoPila (char dia,int diaNum,int unidad) {
    this.dato= dia;
    this.dato2 = diaNum;
    this.dato3 = unidad;
    this.nodoAbajo=null;
    }
    
    public NodoPila (char valorDato,int diaNum,int unidad,NodoPila valorNodoAbajo) {
    this.dato = valorDato;
    this.dato2 = diaNum;
    this.dato3 = unidad;
    this.nodoAbajo = valorNodoAbajo;
    }
}
