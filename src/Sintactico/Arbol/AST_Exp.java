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
public abstract class AST_Exp {

    public AST_ExpSimpl N_ExpSimpl;

    public abstract Object visit(visitor v);
}
