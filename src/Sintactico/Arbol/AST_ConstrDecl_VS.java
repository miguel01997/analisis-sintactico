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
public class AST_ConstrDecl_VS extends AST_ConstrDecl {

    public AST_VarDecl N_VarDecl;
    public AST_Statement N_Statement;
    
    public Object visit(visitor v){
        return v.visitConstrDecl_VS(this);
    }

}
