/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

import Visitor.visitor;

/**
 *
 * @author Estudiantes
 */
public abstract class AST_Program extends AST{
    public abstract Object visit(visitor v);

}
