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
public class AST_TypeName_Lista extends AST_TypeName {

    public AST_TypeName N;
    public AST_TypeName ext;

    public AST_TypeName_Lista() {
    }

    public Object visit(visitor v){
        return v.visitTypeName_Lista(this);
    }


}
