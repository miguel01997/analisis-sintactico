/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_MethodDecl_Body_S extends AST_MethodDecl_Body {

    public AST_Statement S;

    public AST_MethodDecl_Body_S() {
    }

    public AST_MethodDecl_Body_S(AST_Statement S) {
        this.S = S;
    }
    

}
