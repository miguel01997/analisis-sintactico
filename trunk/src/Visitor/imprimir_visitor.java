/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Visitor;

import Sintactico.Arbol.AST_BodyDecl_Lista;
import Sintactico.Arbol.AST_ClassDecl_Lista;
import Sintactico.Arbol.AST_ClassDecl_Simple;
import Sintactico.Arbol.AST_ClassDecl_Simple_E;
import Sintactico.Arbol.AST_ClassDecl_Simple_I;
import Sintactico.Arbol.AST_ConstrDecl;
import Sintactico.Arbol.AST_ConstrDecl_S;
import Sintactico.Arbol.AST_ConstrDecl_V;
import Sintactico.Arbol.AST_ConstrDecl_VS;
import Sintactico.Arbol.AST_ExpList_Lista;
import Sintactico.Arbol.AST_ExpList_Simple;
import Sintactico.Arbol.AST_ExpSimpl_False;
import Sintactico.Arbol.AST_ExpSimpl_Id;
import Sintactico.Arbol.AST_ExpSimpl_IntegerLiteral;
import Sintactico.Arbol.AST_ExpSimpl_Negacion;
import Sintactico.Arbol.AST_ExpSimpl_New;
import Sintactico.Arbol.AST_ExpSimpl_NewInt;
import Sintactico.Arbol.AST_ExpSimpl_Parentesis;
import Sintactico.Arbol.AST_ExpSimpl_StringConstant;
import Sintactico.Arbol.AST_ExpSimpl_This;
import Sintactico.Arbol.AST_ExpSimpl_True;
import Sintactico.Arbol.AST_Exp_Exp;
import Sintactico.Arbol.AST_Exp_Id;
import Sintactico.Arbol.AST_Exp_Length;
import Sintactico.Arbol.AST_Exp_Op;
import Sintactico.Arbol.AST_Exp_Terminal;
import Sintactico.Arbol.AST_Exp_TerminalBody_Lista;
import Sintactico.Arbol.AST_Exp_TerminalBody_Simple;
import Sintactico.Arbol.AST_FormalList_Lista;
import Sintactico.Arbol.AST_FormalList_Simple;
import Sintactico.Arbol.AST_Import_Asterisco;
import Sintactico.Arbol.AST_Import_Lista;
import Sintactico.Arbol.AST_Import_Simple;
import Sintactico.Arbol.AST_Main;
import Sintactico.Arbol.AST_MethodDecl;
import Sintactico.Arbol.AST_MethodDecl_Body_S;
import Sintactico.Arbol.AST_MethodDecl_Body_V;
import Sintactico.Arbol.AST_MethodDecl_Body_VS;
import Sintactico.Arbol.AST_MethodDecl_Type;
import Sintactico.Arbol.AST_MethodDecl_Type_R;
import Sintactico.Arbol.AST_MethodDecl_Void;
import Sintactico.Arbol.AST_MethodDecl_Void_R;
import Sintactico.Arbol.AST_Op;
import Sintactico.Arbol.AST_Program_IM;
import Sintactico.Arbol.AST_Program_IMC;
import Sintactico.Arbol.AST_Program_M;
import Sintactico.Arbol.AST_Program_MC;
import Sintactico.Arbol.AST_Statement_Asign;
import Sintactico.Arbol.AST_Statement_Asign_Compuesto;
import Sintactico.Arbol.AST_Statement_Id;
import Sintactico.Arbol.AST_Statement_Id_Id;
import Sintactico.Arbol.AST_Statement_If;
import Sintactico.Arbol.AST_Statement_Lista;
import Sintactico.Arbol.AST_Statement_SE;
import Sintactico.Arbol.AST_Statement_SIR;
import Sintactico.Arbol.AST_Statement_SOP;
import Sintactico.Arbol.AST_Statement_Simple;
import Sintactico.Arbol.AST_Statement_Statement_Lista;
import Sintactico.Arbol.AST_Statement_Statement_Simple;
import Sintactico.Arbol.AST_Statement_This;
import Sintactico.Arbol.AST_Statement_While;
import Sintactico.Arbol.AST_TypeName_Lista;
import Sintactico.Arbol.AST_TypeName_Simple;
import Sintactico.Arbol.AST_Type_I;
import Sintactico.Arbol.AST_Type_T;
import Sintactico.Arbol.AST_VarDecl_Lista;
import Sintactico.Arbol.AST_VarDecl_Simple;

/**
 *
 * @author Javier
 */
public class imprimir_visitor implements visitor{

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
