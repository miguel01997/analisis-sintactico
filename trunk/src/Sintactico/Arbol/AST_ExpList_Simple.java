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
public class AST_ExpList_Simple extends AST_ExpList{

   public AST_Exp N_Exp;

    public AST_ExpList_Simple() {
    }
   
    public Object visit(visitor v){
        return v.visitExpList_Simple(this);
    }
}
