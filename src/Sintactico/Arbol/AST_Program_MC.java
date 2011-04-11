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
public class AST_Program_MC extends AST_Program {


    public AST_Main N_Main;
    public AST_ClassDecl N_ClassDecl;

    public AST_Program_MC() {
    }
    
    public Object visit(visitor v){
        return v.visitProgram_MC(this);
    }

  

}
