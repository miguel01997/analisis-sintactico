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
public class AST_Type_I extends AST_Type{
    public String id;

    public AST_Type_I() {
    }
    public Object visit(visitor v){
        return v.visitType_I(this);
    }

}
