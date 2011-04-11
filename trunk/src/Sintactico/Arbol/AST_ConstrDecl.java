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
public class AST_ConstrDecl extends AST_BodyDecl_Simple {

  public String id;
  public AST_FormalList N_FormalList;

    public AST_ConstrDecl() {
    }

    @Override
    public Object visit(visitor v) {
        return v.visitConstrDecl(this);
    }


  

}
