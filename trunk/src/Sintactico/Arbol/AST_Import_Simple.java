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
public class AST_Import_Simple extends AST_Import{

    public AST_TypeName N_TypeName;
    
    public Object visit(visitor v){
        return v.visitImport_Simple(this);
    }

}
