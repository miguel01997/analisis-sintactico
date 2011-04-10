/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_Statement_Statement_Lista extends AST_Statement_Statement {
    
    public AST_Statement N_Statement;
    public AST_Statement extN;

    public AST_Statement_Statement_Lista() {
    }

    public AST_Statement_Statement_Lista(AST_Statement N_Statement, AST_Statement extN) {
        this.N_Statement = N_Statement;
        this.extN = extN;
    }
    
    


}
