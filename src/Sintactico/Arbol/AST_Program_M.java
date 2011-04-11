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
public class AST_Program_M extends AST_Program {


    public AST_Main N_Main;

    public AST_Program_M() {
    }

    public Object visit(visitor v){
        return v.visitProgram_M(this);
    }

}
