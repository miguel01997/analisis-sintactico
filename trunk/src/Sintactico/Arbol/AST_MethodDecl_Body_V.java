/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_MethodDecl_Body_V extends AST_MethodDecl_Body {

    public AST_VarDecl V;

    public AST_MethodDecl_Body_V() {
    }

    public AST_MethodDecl_Body_V(AST_VarDecl V) {
        this.V = V;
    }



}
