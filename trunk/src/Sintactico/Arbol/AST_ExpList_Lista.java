/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;
import Visitor.*;

/**
 *
 * @author lidier
 */
public class AST_ExpList_Lista extends AST_ExpList {

    public AST_ExpList sig;
    public AST_ExpList N;

    public AST_ExpList_Lista() {
    }
    
    public Object visit(visitor v){
        return v.visitExpList_Lista(this);
    }

}
