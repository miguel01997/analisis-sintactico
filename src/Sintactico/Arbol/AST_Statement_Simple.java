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
public abstract class AST_Statement_Simple extends AST_Statement {

    public abstract Object visit(visitor v);

}
