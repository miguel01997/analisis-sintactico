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
public abstract class AST_Exp_TerminalBody_Simple extends AST_Exp_TerminalBody {
    
    public abstract Object visit(visitor v);

}
