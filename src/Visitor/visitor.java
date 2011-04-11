/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Visitor;
import Sintactico.Arbol.*;

/**
 *
 * @author Javier
 */
public interface visitor {
    
    void visitBodyDecl_Lista (AST_BodyDecl_Lista N);
    void visitBodyDecl_Simple (AST_BodyDecl_Simple N);
    void visitClassDecl_Lista (AST_ClassDecl_Lista N);
    void visitClassDecl_Simple (AST_ClassDecl_Simple N);
    void visitClassDecl_Simple_E (AST_ClassDecl_Simple_E N);
    void visitClassDecl_Simple_I (AST_ClassDecl_Simple_I N);
    void visitConstrDecl_S (AST_ConstrDecl_S N);
    void visitConstrDecl_V (AST_ConstrDecl_V N);
    void visitConstrDecl_VS (AST_ConstrDecl_VS N);
    void visitExpList_Lista (AST_ExpList_Lista N);
    void visitExpList_Simple (AST_ExpList_Simple N);
    void visitExpSimpl_False (AST_ExpSimpl_False N);
    void visitExpSimpl_Id (AST_ExpSimpl_Id N);
    void visitExpSimpl_IntegerLiteral (AST_ExpSimpl_IntegerLiteral N);
    void visitExpSimpl_Negacion (AST_ExpSimpl_Negacion N);
    void visitExpSimpl_New (AST_ExpSimpl_New N);
    void visitExpSimpl_NewInt (AST_ExpSimpl_NewInt N);
    void visitExpSimpl_Parentesis (AST_ExpSimpl_Parentesis N);
    void visitExpSimpl_StringConstant (AST_ExpSimpl_StringConstant N);
    void visitExpSimpl_This (AST_ExpSimpl_This N);
    void visitExpSimpl_True (AST_ExpSimpl_True N);
    void visitExp_Exp (AST_Exp_Exp N);
    void visitExp_Id (AST_Exp_Id N);
    void visitExp_Length (AST_Exp_Length N);
    void visitExp_Op (AST_Exp_Op N);
    void visitExp_Terminal (AST_Exp_Terminal N);
    void visitExp_TerminalBody (AST_Exp_TerminalBody N);
    void visitExp_TerminalBody_Lista (AST_Exp_TerminalBody_Lista N);
    void visitExp_TerminalBody_Simple (AST_Exp_TerminalBody_Simple N);
    void visitFormalList_Simple (AST_FormalList_Simple N);
    void visitFormalList_Lista (AST_FormalList_Lista N);
    void visitImport_Asterisco (AST_Import_Asterisco N);
    void visitImport_Lista (AST_Import_Lista N);
    void visitImport_Simple (AST_Import_Simple N);
    void visitMain (AST_Main N);
    void visitMethodDecl_Body_S (AST_MethodDecl_Body_S N);
    void visitMethodDecl_Body_VS (AST_MethodDecl_Body_VS N);
    void visitMethodDecl_Body_V (AST_MethodDecl_Body_V N);
    void visitMethodDecl_Type (AST_MethodDecl_Type N);
    void visitMethodDecl_Void (AST_MethodDecl_Void N);
    void visitMethodDecl_Void_R (AST_MethodDecl_Void_R N);
    void visitOp (AST_Op N);
    void visitProgram_IM (AST_Program_IM N);
    void visitProgram_IMC (AST_Program_IMC N);
    void visitProgram_M (AST_Program_M N);
    void visitProgram_MC (AST_Program_MC N);
    void visitStatement_Asign (AST_Statement_Asign N);
    void visitStatement_Asign_Compuesto (AST_Statement_Asign_Compuesto N);
    void visitStatement_Id (AST_Statement_Id N);
    void visitStatement_Id_Id (AST_Statement_Id_Id N);
    void visitStatement_If (AST_Statement_If N);
    void visitStatement_Lista (AST_Statement_Lista N);
    void visitStatement_SE (AST_Statement_SE N);
    void visitStatement_SIR (AST_Statement_SIR N);
    void visitStatement_SOP (AST_Statement_SOP N);
    void visitStatement_Simple (AST_Statement_Simple N);
    void visitStatement_Statement_Lista (AST_Statement_Statement_Lista N);
    void visitStatement_Statement_Simple (AST_Statement_Statement_Simple N);
    void visitStatement_This (AST_Statement_This N);
    void visitStatement_While (AST_Statement_While N);
    void visitType_I (AST_Type_I N);
    void visitType_T (AST_Type_T N);
    void visitTypeName_Lista (AST_TypeName_Lista N);
    void visitTypeName_Simple (AST_TypeName_Simple N);
    void visitVarDecl_Lista (AST_VarDecl_Lista N);
    void visitVarDecl_Simple (AST_VarDecl_Simple N);
}
