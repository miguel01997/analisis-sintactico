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
public class AST_Statement_SIR extends AST_Statement_Simple {

    public AST_Type N_Type;

    public AST_Statement_SIR() {
    }
    public Object visit(visitor v){
        return v.visitStatement_SIR(this);
    }

}
