/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_VarDecl_Lista extends AST_VarDecl {

    AST_VarDecl sig;

    public AST_VarDecl_Lista(AST_Type t, String i, AST_VarDecl sig) {
        
        N_Type = t;
        id = i;
        this.sig = sig;
    }



}
