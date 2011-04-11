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
public class AST_FormalList_Simple extends AST_FormalList{

  public AST_Type N_Type;
  public String id;

    public AST_FormalList_Simple() {
    }
    
    public Object visit(visitor v){
        return v.visitFormalList_Simple(this);
    }
  
  

}
