/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;
import Visitor.*;

/**
 *
 * @author lidier
 */
public class AST_ConstrDecl_V extends AST_ConstrDecl {

    public AST_VarDecl N_VarDecl;
    
    public Object visit(visitor v){
        return v.visitConstrDecl_V(this);
    }
}
