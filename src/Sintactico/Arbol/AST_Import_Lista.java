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
public class AST_Import_Lista extends AST_Import {

    public AST_Import N_Import;
    public AST_Import extN;

    public AST_Import_Lista() {
    }
    
    public Object visit(visitor v){
        return v.visitImport_Lista(this);
    }



}
