/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_MethodDecl_Type_R extends AST_MethodDecl_Type {

    public AST_Exp R_Exp;

    public AST_MethodDecl_Type_R() {
    }

    public AST_MethodDecl_Type_R(String id, AST_FormalList N_FormalList, AST_MethodDecl_Body N_MethodDecl_Body, AST_Type N_Type, AST_Exp R_Exp) {
        this.R_Exp = R_Exp;
        this.N_FormalList=N_FormalList;
        this.id = id;
        this.N_MethodDecl_Body=N_MethodDecl_Body;
        this.N_Type=N_Type;
    }
    
    


}