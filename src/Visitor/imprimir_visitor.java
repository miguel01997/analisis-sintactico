/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Visitor;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.text.*;
import Sintactico.Arbol.*;
import java.awt.GridLayout;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 *
 * @author Javier
 */
public class imprimir_visitor implements visitor{
    
  public void imprimir(AST raiz)
  {
    DefaultMutableTreeNode root;
    root=new DefaultMutableTreeNode("AST");
    root.add((MutableTreeNode) raiz.visit(this));
   final DefaultTreeModel model = new DefaultTreeModel(root);
      final JTree tree = new JTree(model);
      // create a text field and button to modify the data model
      JPanel addPanel = new JPanel(new GridLayout(2, 1));

      // listen for selections
    tree.addTreeSelectionListener(new TreeSelectionListener(  ) {
    public void valueChanged(TreeSelectionEvent e)
    {
          TreePath tp = e.getNewLeadSelectionPath(  );
    }
    });
      // create a JFrame to hold the tree
     JFrame frame = new JFrame("Arbol de Sintaxis Abstracta");

      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.setSize(400,600);
      frame.getContentPane().add(new JScrollPane(tree));
      frame.getContentPane().add(addPanel, BorderLayout.SOUTH);
      frame.setVisible(true);
  }
   public Object List_nor_classdec(Object o, List_nor_classdec arg) {

        DefaultMutableTreeNode v = new DefaultMutableTreeNode(arg.getClass().getName() );
        int numaux = ((Integer)o).intValue();
        v.add((MutableTreeNode)arg.nodo.visit(this, new Integer(numaux+1)));
        v.add((MutableTreeNode)arg.sig.visit(this, new Integer(numaux+1)));
        return v;

    }
    
    public Object visitBodyDecl_Lista(AST_BodyDecl_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitClassDecl_Lista(AST_ClassDecl_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitClassDecl_Simple(AST_ClassDecl_Simple N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitClassDecl_Simple_E(AST_ClassDecl_Simple_E N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitClassDecl_Simple_I(AST_ClassDecl_Simple_I N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitConstrDecl(AST_ConstrDecl N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitConstrDecl_S(AST_ConstrDecl_S N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitConstrDecl_V(AST_ConstrDecl_V N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitConstrDecl_VS(AST_ConstrDecl_VS N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpList_Lista(AST_ExpList_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpList_Simple(AST_ExpList_Simple N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_False(AST_ExpSimpl_False N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_Id(AST_ExpSimpl_Id N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_IntegerLiteral(AST_ExpSimpl_IntegerLiteral N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_Negacion(AST_ExpSimpl_Negacion N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_New(AST_ExpSimpl_New N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_NewInt(AST_ExpSimpl_NewInt N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_Parentesis(AST_ExpSimpl_Parentesis N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_StringConstant(AST_ExpSimpl_StringConstant N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_This(AST_ExpSimpl_This N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExpSimpl_True(AST_ExpSimpl_True N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExp_Exp(AST_Exp_Exp N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExp_Id(AST_Exp_Id N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExp_Length(AST_Exp_Length N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExp_Op(AST_Exp_Op N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExp_Terminal(AST_Exp_Terminal N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExp_TerminalBody_Lista(AST_Exp_TerminalBody_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitExp_TerminalBody_Simple(AST_Exp_TerminalBody_Simple N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitFormalList_Simple(AST_FormalList_Simple N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitFormalList_Lista(AST_FormalList_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitImport_Asterisco(AST_Import_Asterisco N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitImport_Lista(AST_Import_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitImport_Simple(AST_Import_Simple N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitMain(AST_Main N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitMethodDecl(AST_MethodDecl N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitMethodDecl_Body_S(AST_MethodDecl_Body_S N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitMethodDecl_Body_VS(AST_MethodDecl_Body_VS N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitMethodDecl_Body_V(AST_MethodDecl_Body_V N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitMethodDecl_Type(AST_MethodDecl_Type N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitMethodDecl_Type_R(AST_MethodDecl_Type_R N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitMethodDecl_Void(AST_MethodDecl_Void N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitMethodDecl_Void_R(AST_MethodDecl_Void_R N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitOp(AST_Op N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitProgram_IM(AST_Program_IM N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitProgram_IMC(AST_Program_IMC N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitProgram_M(AST_Program_M N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitProgram_MC(AST_Program_MC N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_Asign(AST_Statement_Asign N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_Asign_Compuesto(AST_Statement_Asign_Compuesto N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_Id(AST_Statement_Id N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_Id_Id(AST_Statement_Id_Id N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_If(AST_Statement_If N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_Lista(AST_Statement_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_SE(AST_Statement_SE N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_SIR(AST_Statement_SIR N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_SOP(AST_Statement_SOP N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_Simple(AST_Statement_Simple N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_Statement_Lista(AST_Statement_Statement_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_Statement_Simple(AST_Statement_Statement_Simple N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_This(AST_Statement_This N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitStatement_While(AST_Statement_While N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitType_I(AST_Type_I N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitType_T(AST_Type_T N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitTypeName_Lista(AST_TypeName_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitTypeName_Simple(AST_TypeName_Simple N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitVarDecl_Lista(AST_VarDecl_Lista N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object visitVarDecl_Simple(AST_VarDecl_Simple N) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
