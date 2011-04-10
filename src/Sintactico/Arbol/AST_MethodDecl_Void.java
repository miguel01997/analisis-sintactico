/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_MethodDecl_Void extends AST_MethodDecl{

    public AST_MethodDecl_Void(String id, AST_FormalList N_FormalList , AST_MethodDecl_Body N_MethodDecl_Body) {
        this.N_FormalList=N_FormalList;
        this.N_MethodDecl_Body=N_MethodDecl_Body;
        this.id=id;
    }

    public AST_MethodDecl_Void() {
    }
    
    
}
