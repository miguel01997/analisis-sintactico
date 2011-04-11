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
public class AST_Import_Asterisco extends AST_Import_Simple{

    
    @Override
    public Object visit(visitor v){
        return v.visitImport_Asterisco(this);
    }

 


}
