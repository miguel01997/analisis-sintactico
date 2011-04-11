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
public class AST_Statement_Asign extends AST_Statement_Id {

     public AST_Exp N_Final_Exp;

    public AST_Statement_Asign() {
    }
     
     public Object visit(visitor v){
        return v.visitStatement_Asign(this);
    }

}
