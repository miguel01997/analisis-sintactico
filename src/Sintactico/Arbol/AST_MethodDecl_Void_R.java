/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_MethodDecl_Void_R extends AST_MethodDecl_Void{

    public AST_Exp R_Exp;

    public AST_MethodDecl_Void_R() {
    }

    public AST_MethodDecl_Void_R(String id, AST_FormalList fl , AST_MethodDecl_Body mb, AST_Exp R_Exp) {
        this.R_Exp = R_Exp;
        this.N_FormalList= fl;
        this.id=id;
        this.N_MethodDecl_Body = mb;
    }
    

}
