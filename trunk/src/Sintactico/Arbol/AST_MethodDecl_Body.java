/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;
import Visitor.*;

/**
 *
 * @author lidier
 */
public class AST_MethodDecl_Body {

    public AST_MethodDecl_Body() {
    }


    public Object visit(visitor v)
    {
        return v.visitMethodDecl_Body(this);
    }

}
