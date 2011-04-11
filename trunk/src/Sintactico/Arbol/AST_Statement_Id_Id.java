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
public class AST_Statement_Id_Id extends AST_Statement_Id {

    public AST_ExpList Expl_final;
    public String id2;

    public AST_Statement_Id_Id() {
    }

    @Override
    public Object visit(visitor v){
        return v.visitStatement_Id_Id(this);
    }
    

}
