/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

import Visitor.visitor;

/**
 *
 * @author lidier
 */
public class AST_Main {
    public String id;
    public String args;
    public AST_Statement N_Statement;

    public AST_Main() {
    }

    public Object visit(visitor v){
        return v.visitMain(this);
    }
 
}
