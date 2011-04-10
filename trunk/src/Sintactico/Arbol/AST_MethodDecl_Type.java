/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_MethodDecl_Type extends AST_MethodDecl {

    public AST_Type N_Type;

    public AST_MethodDecl_Type() {
    }

    public AST_MethodDecl_Type(String id, AST_FormalList N_FormalList, AST_MethodDecl_Body N_MethodDecl_Body, AST_Type N_Type) {
        this.N_Type = N_Type;
        this.N_FormalList = N_FormalList;
        this.N_MethodDecl_Body = N_MethodDecl_Body;
        this.id = id;
    }
    
    
    

}
