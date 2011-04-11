/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

import Visitor.visitor;

/**
 *
 * @author Javier
 */
public abstract class AST {
    public abstract Object visit(visitor v);
}
