/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico.Arbol;

import Visitor.visitor;

/**
 *
 * @author lidier
 */
public class AST_Statement_Id extends AST_Statement_Simple {
    public String id;
    
    public Object visit(visitor v){
        return v.visitStatement_Id(this);
    }
    
}
