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
public class AST_ExpSimpl_Parentesis extends AST_ExpSimpl {

    public AST_Exp N_Exp;

    public AST_ExpSimpl_Parentesis() {
    }
    
    public Object visit(visitor v){
        return v.visitExpSimpl_Parentesis(this);
    }

    

}
