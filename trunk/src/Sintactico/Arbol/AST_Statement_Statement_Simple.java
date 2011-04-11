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
public class AST_Statement_Statement_Simple extends AST_Statement_Statement  {

    public AST_Statement N_Statement;

    public AST_Statement_Statement_Simple() {
    }
    @Override
   public Object visit(visitor v){
        return v.visitStatement_Statement_Simple(this);
    }
}
