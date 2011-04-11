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
public class AST_ClassDecl_Simple extends AST_ClassDecl {

    public String id;
    public AST_BodyDecl N_BodyDecl;

    public AST_ClassDecl_Simple() {
    }
    
    public Object visit(visitor v){
        return v.visitClassDecl_Simple(this);
    }
    
    
    

}
