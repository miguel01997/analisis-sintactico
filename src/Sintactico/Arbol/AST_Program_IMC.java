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
public class AST_Program_IMC extends AST_Program {

    public AST_Import N_Imports;
    public AST_Main N_Main;
    public AST_ClassDecl N_ClassDecl;

    public AST_Program_IMC() {
    }
    
    public Object visit(visitor v){
        return v.visitProgram_IMC(this);
    }
}
