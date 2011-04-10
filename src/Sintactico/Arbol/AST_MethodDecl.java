/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public abstract class AST_MethodDecl extends AST_BodyDecl_Simple {

    public String id;
    public AST_FormalList N_FormalList;
    public AST_MethodDecl_Body N_MethodDecl_Body;

    public AST_MethodDecl() {
    }

    public AST_MethodDecl(String id, AST_FormalList N_FormalList, AST_MethodDecl_Body N_MethodDecl_Body) {
        this.id = id;
        this.N_FormalList = N_FormalList;
        this.N_MethodDecl_Body = N_MethodDecl_Body;
    }


 


}
