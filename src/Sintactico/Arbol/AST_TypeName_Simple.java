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
public class AST_TypeName_Simple extends AST_TypeName {

    public String id;

    public AST_TypeName_Simple() {
    }

    public Object visit(visitor v){
        return v.visitTypeName_Simple(this);
    }
}
