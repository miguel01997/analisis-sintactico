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
public class AST_Statement_SE extends AST_Statement_Simple {

    public int Int_Lit;

    public AST_Statement_SE() {
    }
    
    public Object visit(visitor v){
        return v.visitStatement_SE(this);
    }


}
