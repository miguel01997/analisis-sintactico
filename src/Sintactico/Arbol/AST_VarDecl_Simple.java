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
public class AST_VarDecl_Simple extends AST_VarDecl {

     public AST_Type N_Type;
    public String id;

    public AST_VarDecl_Simple() {
    }
    
    public Object visit(visitor v){
        return v.visitVarDecl_Simple(this);
    }

}
