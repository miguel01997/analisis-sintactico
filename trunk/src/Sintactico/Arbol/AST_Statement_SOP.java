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
public class AST_Statement_SOP extends AST_Statement_Simple {

    public AST_Exp N_Exp;

    public AST_Statement_SOP() {
    }
    public Object visit(visitor v){
        return v.visitStatement_SOP(this);
    }

}
