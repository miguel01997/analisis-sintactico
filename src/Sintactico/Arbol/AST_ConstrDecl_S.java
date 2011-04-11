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
public class AST_ConstrDecl_S extends AST_ConstrDecl {

    public AST_Statement N_Statement;
    
    public Object visit(visitor v){
        return v.visitConstrDecl_S(this);
    }

}
