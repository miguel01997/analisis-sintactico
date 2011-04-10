/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_TypeName_Lista extends AST_TypeName {

    String id;
    AST_TypeName sig;

    public AST_TypeName_Lista(String id, AST_TypeName sig) {
        this.id = id;
        this.sig = sig;
    }


}
