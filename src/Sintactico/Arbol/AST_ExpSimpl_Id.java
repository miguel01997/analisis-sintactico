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
public class AST_ExpSimpl_Id extends AST_ExpSimpl {

    public String id;

    public AST_ExpSimpl_Id() {
    }
    
    public Object visit(visitor v){
        return v.visitExpSimpl_Id(this);
    }

    
}
