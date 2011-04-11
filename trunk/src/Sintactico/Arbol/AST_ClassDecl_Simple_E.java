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
public class AST_ClassDecl_Simple_E extends AST_ClassDecl_Simple {

    
    public String extends_id;

    public AST_ClassDecl_Simple_E() {
    }
    
    @Override
    public Object visit(visitor v){
        return v.visitClassDecl_Simple_E(this);
    }

}
