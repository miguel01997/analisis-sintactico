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
public class AST_Exp_Length extends AST_Exp_TerminalBody_Simple {
   public Object visit(visitor v){
        return v.visitExp_Length(this);
    }

}
