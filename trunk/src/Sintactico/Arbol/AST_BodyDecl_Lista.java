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
public class AST_BodyDecl_Lista extends AST_BodyDecl{

    AST_BodyDecl N_BodyDecl;
    AST_BodyDecl sig;

    public AST_BodyDecl_Lista() {
    }

    public AST_BodyDecl_Lista(AST_BodyDecl N_BodyDecl, AST_BodyDecl sig) {
        this.N_BodyDecl = N_BodyDecl;
        this.sig = sig;
    }
    
    public Object visit(visitor v){
        return v.visitBodyDecl_Lista(this);
    }
    

}
