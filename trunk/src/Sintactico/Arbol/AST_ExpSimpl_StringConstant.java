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
public class AST_ExpSimpl_StringConstant extends AST_ExpSimpl {

    public String N_StringConstant;

    public AST_ExpSimpl_StringConstant() {
    }

    public Object visit(visitor v){
        return v.visitExpSimpl_StringConstant(this);
    }
    

}
