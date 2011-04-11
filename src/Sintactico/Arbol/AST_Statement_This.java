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
public class AST_Statement_This extends AST_Statement_Simple {

    public String id;

    public AST_ExpList N_ExpList;

    public AST_Statement_This() {
    }
    @Override
    public Object visit(visitor v){
        return v.visitStatement_This(this);
    }

}
