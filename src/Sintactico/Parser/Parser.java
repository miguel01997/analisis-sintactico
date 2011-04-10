package Sintactico.Parser;

import Sintactico.*;
import Sintactico.Scanner.Scanner;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Sintactico.Arbol.*;

public class Parser
{
  private static Scanner scanner;
  private Sintactico.Token token_actual;
  boolean importesmult, methodesid, methodesid2/*Para identificar si el id es de Vardecl o Statement*/ ;
  int contllave;
  
  private void accept(int esperado) throws MyException 
  {
      if (token_actual.tipo == Sym.TllaveInicio)
          contllave++;
      if (token_actual.tipo == Sym.TllaveFinal)
          contllave--;
      if (token_actual.tipo != esperado)
      {
           System.out.println("Error. Se esperaba " + errores(esperado) + " en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
        //throw new MyException("Compilación Fallida");
        throw new MyException("Error en el analisis sintactico. Se esperaba " + errores(esperado) + " en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      }        
      else
          sigToken();
  }

  private void sigToken() throws MyException {
        try {
            token_actual = scanner.nextToken();
            if ((token_actual == null)&&(contllave!=0))
            {
                throw new MyException("Error en el analisis sintactico: Código incompleto");
            }
            //System.out.print("se leyo un token");
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
    
  }


  public AST parse() throws MyException {
      AST arbol = null;
      sigToken();
    arbol = parseProgram();
    
    if (token_actual != null)
    {
      System.out.println("Basura al final del archivo");
      throw new MyException("Error en el analisis sintactico: Basura al final del archivo");

    }
    else
    {
        System.out.println("Compilación Exitosa");
        //throw new MyException("Compilación Exitosa", 1, "Enhorabuena");
        return arbol;
    }
}
  
  public AST_Program parseProgram() throws MyException
  {
      AST_Program program = null;
      AST_Import I = null;
      AST_Main M = null;
      AST_ClassDecl C = null;

      importesmult = false;
      methodesid = false;
      methodesid2 = false;

      while (token_actual.tipo == Sym.Timport) //mientras que venga la palabra import
      {
          if (I == null)
          {
              I = parseImportdecl();
          }
        else
          {
              AST_Import t = parseImportdecl();
              AST_Import_Lista l = new AST_Import_Lista();
              l.N_Import = I;
              l.extN = t;
              I = l;
        }

      }

      M = parseMainclass(); //El main class es necesario

      while ((token_actual!=null)&&(token_actual.tipo == Sym.Tclass)) //en caso de haber mas clases
      {
          if (C == null)
          {
              C = parseClassdecl();
          }
        else
          {
              AST_ClassDecl t = parseClassdecl();
              AST_ClassDecl_Lista l = new AST_ClassDecl_Lista();
              l.N = C;
              l.extN = t;
              C = l;
        }
      }

      if (I == null)
      {
          if (C == null)
          {
              AST_Program_M p = new AST_Program_M();
              p.N_Main = M;
              program = p;
          }
        else
          {
              AST_Program_MC p = new AST_Program_MC();
              p.N_Main = M;
              p.N_ClassDecl = C;
              program = p;
        }
      }
 else
     if (C == null)
          {
              AST_Program_IM p = new AST_Program_IM();
              p.N_Main = M;
              p.N_Imports = I;
              program = p;
          }
        else
          {
              AST_Program_IMC p = new AST_Program_IMC();
              p.N_Imports = I;
              p.N_Main = M;
              p.N_ClassDecl = C;
              program = p;
        }
   

      return program;

  }
  
  public AST_Import parseImportdecl() throws MyException
  {
      AST_Import I = null;
      AST_TypeName TN;
      accept(Sym.Timport);
      TN=parseTypename();
      if (importesmult)
          {
              AST_Import_Asterisco IA = new AST_Import_Asterisco();
              IA.N_TypeName = TN;
              I = IA;
              importesmult = false;
              accept(Sym.Tmultiplicacion);
              while (token_actual.tipo == Sym.Tpunto)
                {
                    sigToken();
                    accept(Sym.Tmultiplicacion);
                }
          }
      if (token_actual.tipo == Sym.Tpunto)
      {
          AST_Import_Asterisco IA = new AST_Import_Asterisco();
              IA.N_TypeName = TN;
              I = IA;
            sigToken();
            accept(Sym.Tmultiplicacion);
      }
      accept(Sym.TpuntoYcoma);
      if (I == null)
      {
          AST_Import_Simple IA = new AST_Import_Simple();
              IA.N_TypeName = TN;
              I = IA;
      }
      return I;
  }
  
  public AST_TypeName parseTypename() throws MyException
  {
      AST_TypeName TN;
      AST_TypeName_Simple TNS = new AST_TypeName_Simple();
      TNS.id = token_actual.lexema.toString();
      TN = TNS;
      accept(Sym.Tidentifier); //Aceptar un identificador
      while (token_actual.tipo == Sym.Tpunto)
      {
          sigToken();
          if (token_actual.tipo != Sym.Tmultiplicacion)
          {
            AST_TypeName_Simple temp = new AST_TypeName_Simple();
            temp.id = token_actual.lexema.toString();
            AST_TypeName_Lista l = new AST_TypeName_Lista();
            l.N=TN;
            l.ext = temp;
            TN = l;
            accept(Sym.Tidentifier);//seguir aceptando identificadores despues de cada punto
            
          }
          else
              importesmult=true;
      }
      return TN;
      }
  
  public AST_Main parseMainclass() throws MyException
  {
    AST_Main M = new AST_Main();
    accept(Sym.Tclass);
    M.id = token_actual.lexema.toString();
    accept(Sym.Tidentifier);
    accept(Sym.TllaveInicio); //aqui decia corcheteInicio, realmente {} esto son llaves
    accept(Sym.Tpublic);
    accept(Sym.Tstatic);
    accept(Sym.Tvoid);
    accept(Sym.Tmain);
    accept(Sym.TparentesisInicio);
    accept(Sym.Tstring);
    M.args = token_actual.lexema.toString();
    accept(Sym.Tidentifier);  //Esta linea faltaba, se tiene que aceptar un identificador
    accept(Sym.TparentesisFinal);
    accept(Sym.TllaveInicio);
    M.N_Statement = parseStatement();
    accept(Sym.TllaveFinal);
    accept(Sym.TllaveFinal);
    return M;
  }
  
  public AST_ClassDecl parseClassdecl() throws MyException
  {
      AST_ClassDecl c;
      AST_ClassDecl_Simple cs = new AST_ClassDecl_Simple();
    accept(Sym.Tclass);
    cs.id = token_actual.lexema.toString();
    accept(Sym.Tidentifier);
    if (token_actual.tipo == Sym.Timplements)
    {
        sigToken();
        AST_ClassDecl_Simple_I i = new AST_ClassDecl_Simple_I();
        i.import_id=token_actual.lexema.toString();
        cs = i;
        accept(Sym.Tidentifier);
    }
    else if (token_actual.tipo == Sym.Textends)
    {
        sigToken();
        AST_ClassDecl_Simple_E E = new AST_ClassDecl_Simple_E();
        E.extends_id=token_actual.lexema.toString();
        cs = E;
        accept(Sym.Tidentifier);
    }
    accept(Sym.TllaveInicio); //aqui ya se avanzo al siguiente token
    cs.N_BodyDecl = parseBodydecl();
    c = cs;
    accept(Sym.TllaveFinal);
    return c;
  }
  
  public AST_BodyDecl parseBodydecl() throws MyException
  {
      
    while ((token_actual.tipo == Sym.Tint)||(token_actual.tipo == Sym.Tboolean)||(token_actual.tipo == Sym.Tidentifier)||(token_actual.tipo == Sym.Tpublic)||(token_actual.tipo == Sym.Tclass))
    {
        if ((token_actual.tipo == Sym.Tint)||(token_actual.tipo == Sym.Tboolean)||(token_actual.tipo == Sym.Tidentifier))
            parseVardecl();
        else if (token_actual.tipo == Sym.Tclass)
            parseClassdecl();
        else
        {
            sigToken();
            if (token_actual.tipo == Sym.Tidentifier)
            {
                String id = token_actual.lexema.toString();
                sigToken();
                if (token_actual.tipo == Sym.TparentesisInicio)
                    parseConstrdecl(id);
                else
                {
                    methodesid = true;
                    parseMethoddecl(id);
                }
            }
            else
            {
                parseMethoddecl("");
            }
            
         
        }
        
    }
        
        
  }
  
  public AST_VarDecl parseVardecl() throws MyException
  {
      AST_VarDecl v = new AST_VarDecl();
      AST_VarDecl_Simple vs = new AST_VarDecl_Simple();
      vs.N_Type=parseType();
      vs.id = token_actual.lexema.toString();
      v = vs;
      accept(Sym.Tidentifier);
      accept(Sym.TpuntoYcoma);
      return v;
  }
  

   public AST_ConstrDecl parseConstrdecl(String id) throws MyException
  {

      AST_ConstrDecl C = null;
      AST_VarDecl V = null;
      AST_Statement S = null;
      AST_FormalList F = null;
      
      accept(Sym.TparentesisInicio);
      F = parseFormallist();
      accept(Sym.TparentesisFinal);
      accept(Sym.TllaveInicio);

      while ((token_actual.tipo == Sym.Tint) || (token_actual.tipo == Sym.Tboolean) || (token_actual.tipo == Sym.Tidentifier))
      {
          if (V == null)
          {
              V = parseVardecl();
          }
          else
          {
              AST_VarDecl t = parseVardecl();
              AST_VarDecl_Lista l = new AST_VarDecl_Lista();
              l.N_VarDecl = V;
              l.extN = t;
              V = l;
          }
      }

      while (token_actual.tipo != Sym.TllaveFinal)
      {
          if (S == null)
          {
              S = parseStatement();
          }
          else
          {
              AST_Statement t = parseStatement();
              AST_Statement_Lista l = new AST_Statement_Lista();
              l.N = S;
              l.extN = t;
              S = l;
          }
      }

      accept(Sym.TllaveFinal);

      if (V == null)
      {
          if (S == null)
          {
              AST_ConstrDecl cons = new AST_ConstrDecl();
              cons.id = id;
              cons.N_FormalList = F;
              C = cons;

          }
        else
          {
              AST_ConstrDecl_S cons = new AST_ConstrDecl_S();
              cons.id = id;
              cons.N_FormalList = F;
              cons.N_Statement = S;
              C = cons;
        }
      }
    else
      {
          if (S == null)
          {
              AST_ConstrDecl_V cons = new AST_ConstrDecl_V();
              cons.id = id;
              cons.N_FormalList = F;
              cons.N_VarDecl = V;
              C = cons;
          }
        else
          {
              AST_ConstrDecl_VS cons = new AST_ConstrDecl_VS();
              cons.id = id;
              cons.N_FormalList = F;
              cons.N_VarDecl = V;
              cons.N_Statement = S;
              C = cons;
        }
      }

      return C;
  }
   
  
  public AST_MethodDecl parseMethoddecl(String id) throws MyException
  {
      if (!methodesid)
      {
      if ((token_actual.tipo == Sym.Tint)||(token_actual.tipo == Sym.Tboolean))
          parseType();
      else if (token_actual.tipo == Sym.Tvoid)
          sigToken();
      else
          throw new MyException("Error en el analisis sintactico. Se esperaba un void, boolean, int o ID, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      }
      accept(Sym.Tidentifier);
      accept(Sym.TparentesisInicio);
      parseFormallist();
      accept(Sym.TparentesisFinal);
      accept(Sym.TllaveInicio);

      

      while ((token_actual.tipo == Sym.Tint) || (token_actual.tipo == Sym.Tboolean) || (token_actual.tipo == Sym.Tidentifier))
      {
         if (token_actual.tipo == Sym.Tidentifier)
         {
             sigToken();
             if (token_actual.tipo == Sym.Tidentifier)
             {
                 sigToken();
                 accept(Sym.TpuntoYcoma);
             }
             else
             {
                 methodesid2 = true;
                 break;
             }
         }
         else
             parseVardecl();
      }

      while ((token_actual.tipo != Sym.Treturn) && (token_actual.tipo != Sym.TllaveFinal))
          parseStatement();
      
      if (token_actual.tipo == Sym.Treturn)
      {
          sigToken();
          parseExp();
          accept(Sym.TpuntoYcoma);
      }
      accept(Sym.TllaveFinal);
  }
    
  public AST_FormalList parseFormallist() throws MyException
  {
      AST_FormalList f = new AST_FormalList();
      if ((token_actual.tipo == Sym.Tint) || (token_actual.tipo == Sym.Tboolean) || (token_actual.tipo == Sym.Tidentifier))
      {
      f.N_Type = parseType();
      f.id = token_actual.lexema.toString();
      accept(Sym.Tidentifier);
      while(token_actual.tipo == Sym.Tcoma)
      {
          
          sigToken();
          AST_FormalList t = new AST_FormalList();
          t.N_Type=parseType();
          t.id = token_actual.lexema.toString();
          AST_FormalList_Lista l = new AST_FormalList_Lista();
          l.N=f;
          l.sig=t;
          f=l;
          accept(Sym.Tidentifier);
      }
      }
      return f;
  }
      
  public AST_Type parseType() throws MyException
  {
      AST_Type t;
      if (token_actual.tipo == Sym.Tint)
      {
          sigToken(); 
          if(token_actual.tipo == Sym.TllaveInicio)
          {
              AST_Type_T tt=new AST_Type_T();
              tt.tipo = AST_Type_T.Tipos.TintegerP;
              t= tt;
              sigToken();
              accept(Sym.TllaveFinal);
          }
          else
          {
            AST_Type_T tt=new AST_Type_T();
              tt.tipo = AST_Type_T.Tipos.Tinteger;
              t= tt;
          }
          
      }
      else if (token_actual.tipo == Sym.Tboolean)
      {
          AST_Type_T tt=new AST_Type_T();
              tt.tipo = AST_Type_T.Tipos.Tboolean;
              t= tt;
          sigToken();
      }
      else if (token_actual.tipo == Sym.Tidentifier)
      {
          AST_Type_I tt=new AST_Type_I();
              tt.id = token_actual.lexema.toString();
              t= tt;
          sigToken(); 
      }
      else
          throw new MyException("Error en el analisis sintactico. Se esperaba un entero, un boolean o un identificador, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      return t;
  }
  
  public AST_Statement parseStatement() throws MyException
  {
      if (methodesid2)
      {
          methodesid2 = false;
          if ((token_actual.tipo == Sym.TcorcheteInicio)||(token_actual.tipo == Sym.Tigual))
          {
          if (token_actual.tipo == Sym.TcorcheteInicio)
          {
            parseExp();
            accept(Sym.TcorcheteFinal);
          }
          accept(Sym.Tigual);
          parseExp();
          accept(Sym.TpuntoYcoma);
          }
          else
          {
              accept(Sym.Tpunto);
              accept(Sym.Tidentifier);
              accept(Sym.TparentesisInicio);
              parseExplist();
              accept(Sym.TparentesisFinal);
              accept(Sym.TpuntoYcoma);
          }
      }
      else if (token_actual.tipo == Sym.TllaveInicio)
      {
          sigToken();
          while (token_actual.tipo != Sym.TllaveFinal) // lo cambie por un while por q pueden haber n statements
              parseStatement();
          accept(Sym.TllaveFinal);
      }
      else if (token_actual.tipo == Sym.Tif)
      {
          sigToken();
          accept(Sym.TparentesisInicio);
          parseExp();
          accept(Sym.TparentesisFinal);
          parseStatement();
          //implementacion del else
          if (token_actual.tipo == Sym.Telse)
          {
              sigToken();
              parseStatement();
          }
          
      }
      else if (token_actual.tipo == Sym.Twhile)
      {
          sigToken();
          accept(Sym.TparentesisInicio);
          parseExp();
          accept(Sym.TparentesisFinal);
          parseStatement();
      }
      else if (token_actual.tipo == Sym.Tsystem)
      {
          sigToken();
          if (token_actual.tipo != Sym.Tpunto)
              throw new MyException("Error en el analisis sintactico. Se esperaba un statement, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
          sigToken();

          if (token_actual.tipo == Sym.Tout)
          {
              sigToken();
              if (token_actual.tipo != Sym.Tpunto)
                    throw new MyException("Error en el analisis sintactico. Se esperaba un statement, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
              sigToken();

              accept(Sym.Tprintln);
              accept(Sym.TparentesisInicio);
              parseExp();
              accept(Sym.TparentesisFinal);
              accept(Sym.TpuntoYcoma);
          }
          else if (token_actual.tipo == Sym.Texit)
          {
              sigToken();
              accept(Sym.TparentesisInicio);
              accept(Sym.TintLiteral);
          //acepte un numero cualquiera.... la otra manera era agregando el 0 por separado al SYM
               accept(Sym.TparentesisFinal);
               accept(Sym.TpuntoYcoma);
          }
          else throw new MyException("Error en el analisis sintactico. Se esperaba un statement, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      }
      else if (token_actual.tipo == Sym.TparentesisInicio)
      {
          sigToken();
          parseType();
          accept(Sym.TparentesisFinal);
          accept(Sym.Tsystem);
          accept(Sym.Tpunto);
          accept(Sym.Tin);
          accept(Sym.Tpunto);
          accept(Sym.Tread);

          accept(Sym.TparentesisInicio);
          accept(Sym.TparentesisFinal);
          accept(Sym.TpuntoYcoma);
      }
      else if (token_actual.tipo == Sym.Tidentifier)
      {
          sigToken();
          if ((token_actual.tipo == Sym.TcorcheteInicio)||(token_actual.tipo == Sym.Tigual))
          {
          if (token_actual.tipo == Sym.TcorcheteInicio)
          {
            parseExp();
            accept(Sym.TcorcheteFinal);
          }
          accept(Sym.Tigual);
          parseExp();
          accept(Sym.TpuntoYcoma);
          }
          else
          {
              accept(Sym.Tpunto);
              accept(Sym.Tidentifier);
              accept(Sym.TparentesisInicio);
              parseExplist();
              accept(Sym.TparentesisFinal);
              accept(Sym.TpuntoYcoma);
          }
      }
      else if (token_actual.tipo == Sym.Tthis)
      {
          sigToken();
          accept(Sym.Tpunto);
          accept(Sym.Tidentifier);
          accept(Sym.TparentesisInicio);
          parseExplist();
          accept(Sym.TparentesisFinal);
          accept(Sym.TpuntoYcoma);
      }
      else
           throw new MyException("Error en el analisis sintactico. Se esperaba un statement, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      
  }
    
  public AST_Exp parseExp() throws MyException
  {
      parseExpSimpl();
      while (((token_actual.tipo > 29) && (token_actual.tipo < 42)) || (token_actual.tipo == Sym.TcorcheteInicio) || (token_actual.tipo == Sym.Tpunto))
      if ((token_actual.tipo > 29) && (token_actual.tipo < 42))
      {
          sigToken();
          parseExp();
      }
      else if (token_actual.tipo == Sym.TcorcheteInicio)
          {
          sigToken();
          parseExp();
          accept(Sym.TcorcheteFinal);
      }
      else if (token_actual.tipo == Sym.Tpunto)
      {
          sigToken();
          if (token_actual.tipo == Sym.Tlength)
          sigToken();
          else if (token_actual.tipo == Sym.Tidentifier)
          {
              sigToken();
              accept(Sym.TparentesisInicio);
              parseExplist();
              accept(Sym.TparentesisFinal);
          }
          else
             throw new MyException("Error en el analisis sintactico. Se esperaba un identificador o length, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      }
  }
  
  
  public AST_ExpSimpl parseExpSimpl() throws MyException
  {
      AST_ExpSimpl Ex = null;
      
      if (token_actual.tipo == Sym.TintLiteral)
      {
          AST_ExpSimpl_IntegerLiteral e = new AST_ExpSimpl_IntegerLiteral();
          e.N_IntegerLiteral = Integer.parseInt(token_actual.lexema.toString());
          Ex = e;
          sigToken();
      }
      else if (token_actual.tipo == Sym.Ttrue)
      {
          AST_ExpSimpl_True e = new AST_ExpSimpl_True();
          Ex = e;
          sigToken();
      }
      else if (token_actual.tipo == Sym.Tfalse)
      {
          AST_ExpSimpl_False e = new AST_ExpSimpl_False();
          Ex = e;
          sigToken();
      }
      else if (token_actual.tipo == Sym.Tidentifier)
      {
          AST_ExpSimpl_Id e = new AST_ExpSimpl_Id();
          e.id = token_actual.lexema.toString();
          Ex = e;
          sigToken();
      }
      else if (token_actual.tipo == Sym.Tthis)
      {
          AST_ExpSimpl_This e = new AST_ExpSimpl_This();
          Ex = e;
          sigToken();
      }
      else if (token_actual.tipo == Sym.Tnew)
      {
          sigToken();
          if (token_actual.tipo == Sym.Tint)
          {
              AST_ExpSimpl_NewInt e = new AST_ExpSimpl_NewInt();
              sigToken();
              accept(Sym.TcorcheteInicio);
              e.N_Exp = parseExp();
              accept(Sym.TcorcheteFinal);
              Ex = e;
          }
          else if (token_actual.tipo == Sym.Tidentifier)
          {
              AST_ExpSimpl_New e = new AST_ExpSimpl_New();
              e.id = token_actual.lexema.toString();
              sigToken();
              accept(Sym.TparentesisInicio);
              e.N_ExpList = parseExplist();
              accept(Sym.TparentesisFinal);
              Ex = e;
          }
          else
             throw new MyException("Error en el analisis sintactico. Se esperaba una un entero o identificador, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");

      }
      else if (token_actual.tipo == Sym.Tnegacion)
      {
          AST_ExpSimpl_Negacion e = new AST_ExpSimpl_Negacion();
          sigToken();
          e.N_Exp = parseExp();
          Ex = e;
      }
      else if (token_actual.tipo == Sym.TparentesisInicio)
      {
          AST_ExpSimpl_Parentesis e = new AST_ExpSimpl_Parentesis();
          sigToken();
          e.N_Exp = parseExp();
          accept(Sym.TparentesisFinal);

          Ex = e;
      }
      else if (token_actual.tipo == Sym.TstringConstant)
      {
          AST_ExpSimpl_StringConstant e = new AST_ExpSimpl_StringConstant();
          e.N_StringConstant = token_actual.lexema.toString();
          sigToken();
          Ex = e;
      }
      else
          throw new MyException("Error en el analisis sintactico. Se esperaba una expresión, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      
      return Ex;

  }
    
  public AST_ExpList parseExplist() throws MyException
  {
      AST_ExpList el = new AST_ExpList();
      if ((token_actual.tipo == Sym.TintLiteral)||(token_actual.tipo == Sym.Ttrue)||(token_actual.tipo == Sym.Tfalse)||(token_actual.tipo == Sym.Tidentifier)||
              (token_actual.tipo == Sym.Tthis)||(token_actual.tipo == Sym.Tnew)||(token_actual.tipo == Sym.Tdiferente)||(token_actual.tipo == Sym.TparentesisInicio)||
              (token_actual.tipo == Sym.TstringConstant))
      {
          
      el.N_Exp=parseExp();
      while(token_actual.tipo == Sym.Tcoma)
      {
          sigToken();
          AST_ExpList t= new AST_ExpList();
          t.N_Exp=parseExp();
          AST_ExpList_Lista ell = new AST_ExpList_Lista();
          ell.N=el;
          ell.sig=t;
          el = ell;
      }
      }
      return el;
  }
    
  public AST_Op parseOp() throws MyException
  {
      AST_Op o=new AST_Op();
      if (token_actual.tipo == 30)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.mas;
          o= ot;
      }
      else if (token_actual.tipo == 31)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.menos;
          o= ot;
      }
      else if (token_actual.tipo == 32)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.multiplicacion;
          o= ot;
      }
      else if (token_actual.tipo == 33)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.division;
          o= ot;
      }
      else if (token_actual.tipo == 34)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.diferente;
          o= ot;
      }
      else if (token_actual.tipo == 35)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.igual;
          o= ot;
      }
      else if (token_actual.tipo == 36)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.menor;
          o= ot;
      }
      else if (token_actual.tipo == 37)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.mayor;
          o= ot;
      }
      else if (token_actual.tipo == 38)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.menorIgual;
          o= ot;
      }
      else if (token_actual.tipo == 39)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.mayorIgual;
          o= ot;
      }
      else if (token_actual.tipo == 40)
      {
          sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.o;
          o= ot;
      }
      if (token_actual.tipo == 41)
      {
       sigToken();
          AST_Op ot=new AST_Op();
          ot.N_Operador = AST_Op.Operadores.y;
          o= ot;   
      }
      else
          throw new MyException("Error en el analisis sintactico. Se esperaba un operador, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      return o;
  }
  
  

  
  public static void main(java.io.InputStream stream)
  {
    try
    {
    scanner = new Scanner(stream);
    Parser p = new Parser();
    p.parse();
    }
    catch(MyException e)
    {System.out.println(e);}
    
  
  }
  
  //método auxiliar para  mostrar en vez del tipo, algo m�s significativo
  public String errores(int sys)
  {
      if (sys == 1)
      return("import");
    if (sys == 2)
      return("class");
    else if (sys == 3)
      return("public");
    else if (sys == 4)
      return("static");
    else if (sys == 5)
      return("void");
    else if (sys == 6)
      return("main");
    else if (sys == 7)
      return("String");
    else if (sys == 8)
      return("igual");
    else if (sys == 9)
      return("extends");
    else if (sys == 10)
      return("implements");
    else if (sys == 11)
      return("return");
    else if (sys == 12)
      return("entero");
    else if (sys == 13)
      return("boolean");
    else if (sys == 14)
      return("if");
    else if (sys == 15)
      return("else");
    else if (sys == 16)
      return("while");
    else if (sys == 20)
      return("length");        
    else if (sys == 21)
      return("numero");
    else if (sys == 22)
      return("true");        
    else if (sys == 23)
      return("false");        
    else if (sys == 24)
      return("this");        
    else if (sys == 25)
      return("new");        
    else if (sys == 26)
      return("string");        
    else if (sys == 27)
      return("negacion");        
    else if (sys == 28)
      return("ID");        
    else if (sys == 29)
      return("numero");        
    else if (sys == 30)
      return("suma");        
    else if (sys == 31)
      return("resta");        
    else if (sys == 32)
      return("division");        
    else if (sys == 33)
      return("multiplicacion");        
    else if (sys == 34)
      return("diferente");        
    else if (sys == 35)
      return("igual");        
    else if (sys == 36)
      return("menor");        
    else if (sys == 37)
      return("mayor");
    else if (sys == 38)
      return("menor-igual");
    else if (sys == 39)
      return("mayor-igual");
    else if (sys == 40)
      return("or");        
    else if (sys == 41)
      return("and");        
    else if (sys == 42)
      return("paren-inicio");        
    else if (sys == 43)
      return("paren-final");        
     else if (sys == 44)
      return("punto y coma");       
    else if (sys == 45)
      return("coma");        
    else if (sys == 46)
      return("corchete inicio");        
    else if (sys == 47)
      return("corchete final");                
    else if (sys == 49)
      return("punto");        
     else if (sys == 50)
      return("llave inicio");       
     else if (sys == 51)
      return("llave final");       
     else if (sys == 52)
      return("system");       
     else if (sys == 53)
      return("out");       
     else if (sys == 54)
      return("println");       
     else if (sys == 55)
      return("in");       
     else if (sys == 56)
      return("read");       
     else if (sys == 57)
      return("exit");               
    else 
      return("EOF");
  }

}
