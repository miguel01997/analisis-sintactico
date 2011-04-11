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
public class AST_ExpSimpl_This extends AST_ExpSimpl {
    
    public Object visit(visitor v){
        return v.visitExpSimpl_This(this);
    }

}
