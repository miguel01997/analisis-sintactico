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
public class AST_ClassDecl_Lista extends AST_ClassDecl {

    public AST_ClassDecl N;
    public AST_ClassDecl extN;

    public AST_ClassDecl_Lista() {
    }
    
    public Object visit(visitor v){
        return v.visitClassDecl_Lista(this);
    }

}
