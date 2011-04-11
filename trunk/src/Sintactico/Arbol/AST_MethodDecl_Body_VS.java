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
public class AST_MethodDecl_Body_VS extends AST_MethodDecl_Body {

    public AST_VarDecl V;
    public AST_Statement S;

    public AST_MethodDecl_Body_VS() {
    }

    public AST_MethodDecl_Body_VS(AST_VarDecl V, AST_Statement S) {
        this.V = V;
        this.S = S;
    }


    

}
