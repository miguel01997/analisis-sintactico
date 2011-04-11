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
public abstract class AST_VarDecl extends AST_BodyDecl_Simple {
   
    public abstract Object visit(visitor v);

}
