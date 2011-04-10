/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_VarDecl extends AST_BodyDecl_Simple {
    AST_Type N_Type;
    String id;

    public AST_VarDecl(AST_Type N_Type, String id) {
        this.N_Type = N_Type;
        this.id = id;
    }
 

    public AST_VarDecl()
    {}




}
