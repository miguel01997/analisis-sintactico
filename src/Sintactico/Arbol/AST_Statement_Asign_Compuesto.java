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
public class AST_Statement_Asign_Compuesto extends AST_Statement_Asign {

    public AST_Exp N_Exp;

    public AST_Statement_Asign_Compuesto() {
    }
    
    @Override
    public Object visit(visitor v){
        return v.visitStatement_Asign_Compuesto(this);
    }
    

}
