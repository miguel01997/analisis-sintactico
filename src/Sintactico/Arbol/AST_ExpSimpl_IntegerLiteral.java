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
public class AST_ExpSimpl_IntegerLiteral extends AST_ExpSimpl {

    public int N_IntegerLiteral;

    public AST_ExpSimpl_IntegerLiteral() {
    }

public Object visit(visitor v){
        return v.visitExpSimpl_IntegerLiteral(this);
    }

}
