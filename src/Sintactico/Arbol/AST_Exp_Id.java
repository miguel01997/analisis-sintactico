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
public class AST_Exp_Id extends AST_Exp_TerminalBody_Simple {
    
    public String id;
    public AST_ExpList N_ExpList;

    public AST_Exp_Id() {
    }
    public Object visit(visitor v){
        return v.visitExp_Id(this);
    }
    

}
