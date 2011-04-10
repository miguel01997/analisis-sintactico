/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_Op {

    public static enum Operadores {mas, menos, multiplicacion, division, diferente, igual, menor, mayor, menorIgual, mayorIgual, o, y};
    Operadores N_Operador;

    public AST_Op(Operadores N_Operador) {
        this.N_Operador = N_Operador;
    }


}
