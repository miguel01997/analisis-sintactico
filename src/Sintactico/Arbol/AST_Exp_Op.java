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
public class AST_Exp_Op extends AST_Exp_TerminalBody_Simple {

    public AST_Op N_Op;
    public AST_Exp N_Exp;

    public AST_Exp_Op() {
    }
    public Object visit(visitor v){
        return v.visitExp_Op(this);
    }

}
