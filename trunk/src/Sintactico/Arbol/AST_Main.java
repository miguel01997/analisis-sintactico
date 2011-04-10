/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

/**
 *
 * @author lidier
 */
public class AST_Main {
    String id;
    String args;
    AST_Statement N_Statement;

    public AST_Main(String id, String args, AST_Statement N_Statement) {
        this.id = id;
        this.args = args;
        this.N_Statement = N_Statement;
    }
 
}
