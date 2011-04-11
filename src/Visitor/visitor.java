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
    
    public Object visitBodyDecl_Lista (AST_BodyDecl_Lista N);
    public Object visitClassDecl_Lista (AST_ClassDecl_Lista N);
    public Object visitClassDecl_Simple (AST_ClassDecl_Simple N);
    public Object visitClassDecl_Simple_E (AST_ClassDecl_Simple_E N);
    public Object visitClassDecl_Simple_I (AST_ClassDecl_Simple_I N);
    public Object visitConstrDecl(AST_ConstrDecl N);
    public Object visitConstrDecl_S (AST_ConstrDecl_S N);
    public Object visitConstrDecl_V (AST_ConstrDecl_V N);
    public Object visitConstrDecl_VS (AST_ConstrDecl_VS N);
    public Object visitExpList_Lista (AST_ExpList_Lista N);
    public Object visitExpList_Simple (AST_ExpList_Simple N);
    public Object visitExpSimpl_False (AST_ExpSimpl_False N);
    public Object visitExpSimpl_Id (AST_ExpSimpl_Id N);
    public Object visitExpSimpl_IntegerLiteral (AST_ExpSimpl_IntegerLiteral N);
    public Object visitExpSimpl_Negacion (AST_ExpSimpl_Negacion N);
    public Object visitExpSimpl_New (AST_ExpSimpl_New N);
    public Object visitExpSimpl_NewInt (AST_ExpSimpl_NewInt N);
    public Object visitExpSimpl_Parentesis (AST_ExpSimpl_Parentesis N);
    public Object visitExpSimpl_StringConstant (AST_ExpSimpl_StringConstant N);
    public Object visitExpSimpl_This (AST_ExpSimpl_This N);
    public Object visitExpSimpl_True (AST_ExpSimpl_True N);
    public Object visitExp_Exp (AST_Exp_Exp N);
    public Object visitExp_Id (AST_Exp_Id N);
    public Object visitExp_Length (AST_Exp_Length N);
    public Object visitExp_Op (AST_Exp_Op N);
    public Object visitExp_Terminal (AST_Exp_Terminal N);
    public Object visitExp_TerminalBody_Lista (AST_Exp_TerminalBody_Lista N);
    //public Object visitExp_TerminalBody_Simple (AST_Exp_TerminalBody_Simple N);
    public Object visitFormalList_Simple (AST_FormalList_Simple N);
    public Object visitFormalList_Lista (AST_FormalList_Lista N);
    public Object visitImport_Asterisco (AST_Import_Asterisco N);
    public Object visitImport_Lista (AST_Import_Lista N);
    public Object visitImport_Simple (AST_Import_Simple N);
    public Object visitMain (AST_Main N);
    public Object visitMethodDecl(AST_MethodDecl N);
    public Object visitMethodDecl_Body(AST_MethodDecl_Body N);
    public Object visitMethodDecl_Body_S (AST_MethodDecl_Body_S N);
    public Object visitMethodDecl_Body_VS (AST_MethodDecl_Body_VS N);
    public Object visitMethodDecl_Body_V (AST_MethodDecl_Body_V N);
    public Object visitMethodDecl_Type (AST_MethodDecl_Type N);
    public Object visitMethodDecl_Type_R (AST_MethodDecl_Type_R N);
    public Object visitMethodDecl_Void (AST_MethodDecl_Void N);
    public Object visitMethodDecl_Void_R (AST_MethodDecl_Void_R N);
    public Object visitOp (AST_Op N);
    public Object visitProgram_IM (AST_Program_IM N);
    public Object visitProgram_IMC (AST_Program_IMC N);
    public Object visitProgram_M (AST_Program_M N);
    public Object visitProgram_MC (AST_Program_MC N);
    public Object visitStatement_Asign (AST_Statement_Asign N);
    public Object visitStatement_Asign_Compuesto (AST_Statement_Asign_Compuesto N);
    public Object visitStatement_Id (AST_Statement_Id N);
    public Object visitStatement_Id_Id (AST_Statement_Id_Id N);
    public Object visitStatement_If (AST_Statement_If N);
    public Object visitStatement_Lista (AST_Statement_Lista N);
    public Object visitStatement_SE (AST_Statement_SE N);
    public Object visitStatement_SIR (AST_Statement_SIR N);
    public Object visitStatement_SOP (AST_Statement_SOP N);
    public Object visitStatement_Statement_Lista (AST_Statement_Statement_Lista N);
    public Object visitStatement_Statement_Simple (AST_Statement_Statement_Simple N);
    public Object visitStatement_This (AST_Statement_This N);
    public Object visitStatement_While (AST_Statement_While N);
    public Object visitType_I (AST_Type_I N);
    public Object visitType_T (AST_Type_T N);
    public Object visitTypeName_Lista (AST_TypeName_Lista N);
    public Object visitTypeName_Simple (AST_TypeName_Simple N);
    public Object visitVarDecl_Lista (AST_VarDecl_Lista N);
    public Object visitVarDecl_Simple (AST_VarDecl_Simple N);
    
}
