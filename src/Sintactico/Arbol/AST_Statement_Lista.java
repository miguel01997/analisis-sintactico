/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_Statement_Lista extends AST_Statement {

    public AST_Statement N;
    public AST_Statement extN;

    public AST_Statement_Lista() {
    }

    public AST_Statement_Lista(AST_Statement N, AST_Statement extN) {
        this.N = N;
        this.extN = extN;
    }

    

}