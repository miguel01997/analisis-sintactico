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
public class AST_Exp_Terminal extends AST_Exp {

    AST_ExpSimpl N_ExpSimpl2;
    AST_Exp_TerminalBody N_Body;

    public AST_Exp_Terminal() {
    }

    public AST_Exp_Terminal(AST_ExpSimpl N_ExpSimpl, AST_Exp_TerminalBody N_Body) {
        this.N_ExpSimpl2 = N_ExpSimpl;
        this.N_Body = N_Body;
    }
    public Object visit(visitor v){
        return v.visitExp_Terminal(this);
    }


    

}
