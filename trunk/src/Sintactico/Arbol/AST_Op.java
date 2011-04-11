/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

import Visitor.visitor;

/**
 *
 * @author lidier
 */
public class AST_Op {

    //public static enum Operadores {mas, menos, multiplicacion, division, diferente, igual, menor, mayor, menorIgual, mayorIgual, o, y};
    //public Operadores N_Operador;

    public int Num_Op;

    public AST_Op() {
    }
    
    public Object visit(visitor v){
        return v.visitOp(this);
    }

    


}
