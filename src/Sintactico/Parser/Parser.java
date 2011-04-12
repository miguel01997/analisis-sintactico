package Sintactico.Parser;
import Sintactico.Exceptions.ParserException;
import Sintactico.Exceptions.ScannerException;
import javax.swing.JOptionPane;
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
  
  private void accept(int esperado) throws ParserException 
  {
      if (token_actual.tipo == Sym.TllaveInicio)
          contllave++;
      if (token_actual.tipo == Sym.TllaveFinal)
          contllave--;
      if (token_actual.tipo != esperado)
      {
           System.out.println("Error. Se esperaba " + errores(esperado) + " en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
        //throw new MyException("Compilación Fallida");
        throw new ParserException("Error en el analisis sintactico. Se esperaba " + errores(esperado) + " en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      }        
      else
          sigToken();
  }

  private void sigToken() throws ParserException {
        try {
            token_actual = scanner.nextToken();
            if ((token_actual == null)&&(contllave!=0))
            {
                throw new ParserException("Error en el analisis: Código incompleto");
            }
            //System.out.print("se leyo un token");
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
      }
        catch (Sintactico.Exceptions.ScannerException e)
        {
            throw new ParserException("El parser no puede continuar debido a un error Scaneando");

        }

      


    
    
  }


  public AST parse() throws ParserException {
      AST arbol = null;
      sigToken();
      if (token_actual != null)
        arbol = parseProgram();
      else
      {
          throw new ParserException("No se encontraron tokens");
      }
    
    if (token_actual != null)
    {
      System.out.println("Basura al final del archivo");
      throw new ParserException("Error en el analisis sintactico: Basura al final del archivo");

    }
    else
    {
        System.out.println("Compilación Exitosa");
        JOptionPane.showMessageDialog(null,"Compilación Exitosa","Enhorabuena", 1);
        return arbol;
    }
}
  
  public AST_Program parseProgram() throws ParserException
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
  
  public AST_Import parseImportdecl() throws ParserException
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
  
  public AST_TypeName parseTypename() throws ParserException
  {
      AST_TypeName TN;
      AST_TypeName_Simple TNS = new AST_TypeName_Simple();
      if(token_actual.tipo==Sym.Tidentifier)
      TNS.id = token_actual.lexema.toString();
      TN = TNS;
      accept(Sym.Tidentifier); //Aceptar un identificador
      while (token_actual.tipo == Sym.Tpunto)
      {
          sigToken();
          if (token_actual.tipo != Sym.Tmultiplicacion)
          {
            AST_TypeName_Simple temp = new AST_TypeName_Simple();
            if(token_actual.tipo==Sym.Tidentifier)
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
  
  public AST_Main parseMainclass() throws ParserException
  {
    AST_Main M = new AST_Main();
    accept(Sym.Tclass);
    if(token_actual.tipo==Sym.Tidentifier)
    M.id = token_actual.lexema.toString();
    accept(Sym.Tidentifier);
    accept(Sym.TllaveInicio); //aqui decia corcheteInicio, realmente {} esto son llaves
    accept(Sym.Tpublic);
    accept(Sym.Tstatic);
    accept(Sym.Tvoid);
    accept(Sym.Tmain);
    accept(Sym.TparentesisInicio);
    accept(Sym.Tstring);
    if(token_actual.tipo==Sym.Tidentifier)
    M.args = token_actual.lexema.toString();
    accept(Sym.Tidentifier);  //Esta linea faltaba, se tiene que aceptar un identificador
    accept(Sym.TparentesisFinal);
    accept(Sym.TllaveInicio);
    M.N_Statement = parseStatement("");
    accept(Sym.TllaveFinal);
    accept(Sym.TllaveFinal);
    return M;
  }
  
  public AST_ClassDecl parseClassdecl() throws ParserException
  {
      AST_ClassDecl c;
      AST_ClassDecl_Simple cs = new AST_ClassDecl_Simple();
    accept(Sym.Tclass);
    if(token_actual.tipo==Sym.Tidentifier)
    cs.id = token_actual.lexema.toString();
    accept(Sym.Tidentifier);
    if (token_actual.tipo == Sym.Timplements)
    {
        sigToken();
        AST_ClassDecl_Simple_I i = new AST_ClassDecl_Simple_I();
        if(token_actual.tipo==Sym.Tidentifier)
        i.implements_id=token_actual.lexema.toString();
        i.id = cs.id;
        cs = i;
        accept(Sym.Tidentifier);
    }
    else if (token_actual.tipo == Sym.Textends)
    {
        sigToken();
        AST_ClassDecl_Simple_E E = new AST_ClassDecl_Simple_E();
        if(token_actual.tipo==Sym.Tidentifier)
        E.extends_id=token_actual.lexema.toString();
        E.id = cs.id;
        cs = E;
        accept(Sym.Tidentifier);
    }
    accept(Sym.TllaveInicio); //aqui ya se avanzo al siguiente token
    cs.N_BodyDecl = parseBodydecl();
    c = cs;
    accept(Sym.TllaveFinal);
    return c;
  }
  
  public AST_BodyDecl parseBodydecl() throws ParserException
  {
      AST_BodyDecl B = null;
  
      
    while ((token_actual.tipo == Sym.Tint)||(token_actual.tipo == Sym.Tboolean)||(token_actual.tipo == Sym.Tidentifier)||(token_actual.tipo == Sym.Tpublic)||(token_actual.tipo == Sym.Tclass))
    {
        AST_BodyDecl_Simple Bd = null;
        if ((token_actual.tipo == Sym.Tint)||(token_actual.tipo == Sym.Tboolean)||(token_actual.tipo == Sym.Tidentifier))
        {
            AST_VarDecl vd = parseVardecl();
            Bd = vd;
        }
        else if (token_actual.tipo == Sym.Tclass)
        {
            AST_ClassDecl cd = parseClassdecl();
            Bd = cd;
        }
        else
        {
            sigToken();
            if (token_actual.tipo == Sym.Tidentifier)
            {
                String id = token_actual.lexema.toString();
                sigToken();
                if (token_actual.tipo == Sym.TparentesisInicio)
                {
                    AST_ConstrDecl cd = parseConstrdecl(id);
                    Bd = cd;
                }
                else
                {
                    methodesid = true;
                    AST_MethodDecl md = parseMethoddecl(id);
                    Bd = md;
                }
            }
            else
            {
                AST_MethodDecl md = parseMethoddecl("");
                Bd = md;
            }
            
         
        }
        if (B == null)
        {
         B = Bd;
        }
        else
        {
            B = new AST_BodyDecl_Lista(B, Bd);
        }
        
    }

      return B;
        
        
  }
  
  public AST_VarDecl parseVardecl() throws ParserException
  {
      AST_VarDecl v = null;
      AST_VarDecl_Simple vs = new AST_VarDecl_Simple();
      vs.N_Type=parseType();
      if(token_actual.tipo==Sym.Tidentifier)
      vs.id = token_actual.lexema.toString();
      v = vs;
      accept(Sym.Tidentifier);
      accept(Sym.TpuntoYcoma);
      return v;
  }
  

   public AST_ConstrDecl parseConstrdecl(String id) throws ParserException
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
              S = parseStatement("");
          }
          else
          {
              AST_Statement t = parseStatement("");
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
   
  
  public AST_MethodDecl parseMethoddecl(String id) throws ParserException
  {

      AST_Type tipo = null;
      AST_MethodDecl Md = null;
      AST_FormalList Fl = null;
      AST_MethodDecl_Body Mbody = null;

      AST_VarDecl BVD = null;
      AST_Statement BSD = null;
      
      AST_Exp returnExp = null;

      String idstatement = "";
      String idlocal="";

      if (!"".equals(id))
      {
          AST_Type_I t = new AST_Type_I();
          t.id=id;
          tipo = t;
      }


      if (!methodesid)
      {
      if ((token_actual.tipo == Sym.Tint)||(token_actual.tipo == Sym.Tboolean))
      {
          tipo =parseType();
          
      }
      else if (token_actual.tipo == Sym.Tvoid)
          sigToken();
      else
          throw new ParserException("Error en el analisis sintactico. Se esperaba un void, boolean, int o ID, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      }
      if(token_actual.tipo==Sym.Tidentifier)
      idlocal=token_actual.lexema.toString();
      accept(Sym.Tidentifier);
      accept(Sym.TparentesisInicio);
      Fl = parseFormallist();
      accept(Sym.TparentesisFinal);
      accept(Sym.TllaveInicio);


      while ((token_actual.tipo == Sym.Tint) || (token_actual.tipo == Sym.Tboolean) || (token_actual.tipo == Sym.Tidentifier))
      {
          AST_VarDecl temp = null;
         if (token_actual.tipo == Sym.Tidentifier)
         {
             AST_VarDecl_Simple vst = new AST_VarDecl_Simple();
             idstatement=token_actual.lexema.toString();
             AST_Type_I ti = new AST_Type_I();
             ti.id=idstatement;
             vst.N_Type = ti;
             sigToken();
             if (token_actual.tipo == Sym.Tidentifier)
             {
                 vst.id=token_actual.lexema.toString();
                 sigToken();
                 accept(Sym.TpuntoYcoma);
             }
             else
             {
                 methodesid2 = true;
                 break;
             }
             temp = vst;
         }
         else
         {
             temp = parseVardecl();
         }
         if (BVD == null)
         {
             BVD=temp;
         }
         else
         {
         AST_VarDecl_Lista l = new AST_VarDecl_Lista(BVD, temp);
         BVD = l;
         }
      }

      while ((token_actual.tipo != Sym.Treturn) && (token_actual.tipo != Sym.TllaveFinal))
      {
          if (BSD == null)
            BSD = parseStatement(idstatement);
          else
          {
              methodesid2=false;
              AST_Statement T = parseStatement(idstatement);
              BSD = new AST_Statement_Lista(BSD, T);
          }
      }
      
      if (token_actual.tipo == Sym.Treturn)
      {
          sigToken();
          returnExp = parseExp();
          accept(Sym.TpuntoYcoma);

      }
      accept(Sym.TllaveFinal);

      if (BVD == null)
      {
          if (BSD==null)
          {
              AST_MethodDecl_Body mbs = new AST_MethodDecl_Body();
              Mbody = mbs;
          }
          else
          {
              AST_MethodDecl_Body_S mbs = new AST_MethodDecl_Body_S(BSD);
              Mbody = mbs;
          }
      }
      else
      {
          AST_MethodDecl_Body_VS mbvs = new AST_MethodDecl_Body_VS(BVD, BSD);
              Mbody = mbvs;
      }
      if (tipo == null)
      {
          if (returnExp == null)
          {
              AST_MethodDecl_Void mv = new AST_MethodDecl_Void(idlocal, Fl, Mbody);
              Md=mv;
          }
          else
          {
              AST_MethodDecl_Void_R mvr = new AST_MethodDecl_Void_R(idlocal, Fl, Mbody, returnExp);
              Md=mvr;
          }
      }
      else
          if (returnExp == null)
          {
              AST_MethodDecl_Type mt = new AST_MethodDecl_Type(idlocal, Fl, Mbody, tipo);
              Md=mt;  
                      
          }
          else
          {
              AST_MethodDecl_Type_R mtr = new AST_MethodDecl_Type_R(idlocal, Fl, Mbody, tipo, returnExp);
              Md=mtr;
          }
      return Md;
  }
    
  public AST_FormalList parseFormallist() throws ParserException
  {
      AST_FormalList fl = null;
      if ((token_actual.tipo == Sym.Tint) || (token_actual.tipo == Sym.Tboolean) || (token_actual.tipo == Sym.Tidentifier))
      {
          AST_FormalList_Simple f = new AST_FormalList_Simple();
      f.N_Type = parseType();
      if(token_actual.tipo==Sym.Tidentifier)
      f.id = token_actual.lexema.toString();
      fl = f;
      accept(Sym.Tidentifier);
      while(token_actual.tipo == Sym.Tcoma)
      {
          
          sigToken();
          AST_FormalList_Simple t = new AST_FormalList_Simple();
          t.N_Type=parseType();
          if(token_actual.tipo==Sym.Tidentifier)
          t.id = token_actual.lexema.toString();
          AST_FormalList_Lista l = new AST_FormalList_Lista();
          l.N=fl;
          l.sig=t;
          fl=l;
          accept(Sym.Tidentifier);
      }
      }
      return fl;
  }
      
  public AST_Type parseType() throws ParserException
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
          throw new ParserException("Error en el analisis sintactico. Se esperaba un entero, un boolean o un identificador, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      return t;
  }
  
  public AST_Statement parseStatement(String id) throws ParserException
  {
      AST_Statement s = null;
      if (methodesid2)
      {
          if ((token_actual.tipo == Sym.TcorcheteInicio)||(token_actual.tipo == Sym.Tigual))
          {
              AST_Statement_Asign_Compuesto sac = null;
              AST_Statement_Asign sa = null;

          if (token_actual.tipo == Sym.TcorcheteInicio)
          {
            sac = new AST_Statement_Asign_Compuesto();
            sac.N_Exp=parseExp();
            sac.id = id;
            accept(Sym.TcorcheteFinal);
            s = sac;

          }
          
          accept(Sym.Tigual);
          if (sac == null)
          {
          sa = new AST_Statement_Asign();
          sa.N_Final_Exp=parseExp();
          sa.id=id;
          s = sa;
          }
          else
          {
            sac.N_Final_Exp=parseExp();
          s = sac;  
          }
          accept(Sym.TpuntoYcoma);
          }
          else
          {
              AST_Statement_Id_Id SII = new AST_Statement_Id_Id();
              SII.id=id;
              accept(Sym.Tpunto);
              if(token_actual.tipo==Sym.Tidentifier)
              SII.id2=token_actual.lexema.toString();
              accept(Sym.Tidentifier);
              accept(Sym.TparentesisInicio);
              SII.Expl_final=parseExplist();
              accept(Sym.TparentesisFinal);
              accept(Sym.TpuntoYcoma);
              s=SII;
          }
      }
      else if (token_actual.tipo == Sym.TllaveInicio)
      {
          AST_Statement_Statement_Simple sss= new AST_Statement_Statement_Simple();
          sigToken();
          int cont = 0;
          while (token_actual.tipo != Sym.TllaveFinal) // lo cambie por un while por q pueden haber n statements
          {
              if (cont ==0)
              {
                  sss.N_Statement =parseStatement("");
                  cont++;
              }
              else
              {
              AST_Statement t =parseStatement("");
              AST_Statement_Statement_Lista l = new AST_Statement_Statement_Lista(sss, t);
              s=l;
              }
          }
          /*if (cont == 0)
          s=sss;*/
          accept(Sym.TllaveFinal);
      }
      else if (token_actual.tipo == Sym.Tif)
      {
          AST_Statement_If SI = new AST_Statement_If();
          sigToken();
          accept(Sym.TparentesisInicio);
          SI.N_Exp=parseExp();
          accept(Sym.TparentesisFinal);
          SI.N_Statement=parseStatement("");
              sigToken();
              SI.N_Else_Statement=parseStatement("");
          s=SI;
      }
      else if (token_actual.tipo == Sym.Twhile)
      {
          AST_Statement_While SW = new AST_Statement_While();
          sigToken();
          accept(Sym.TparentesisInicio);
          SW.N_Exp=parseExp();
          accept(Sym.TparentesisFinal);
          SW.N_Statement=parseStatement("");
          s=SW;
      }
      else if (token_actual.tipo == Sym.Tsystem)
      {
          sigToken();
          if (token_actual.tipo != Sym.Tpunto)
              throw new ParserException("Error en el analisis sintactico. Se esperaba un statement, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
          sigToken();

          if (token_actual.tipo == Sym.Tout)
          {
              AST_Statement_SOP ssop = new AST_Statement_SOP();
              sigToken();
              if (token_actual.tipo != Sym.Tpunto)
                    throw new ParserException("Error en el analisis sintactico. Se esperaba un statement, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
              sigToken();

              accept(Sym.Tprintln);
              accept(Sym.TparentesisInicio);
              ssop.N_Exp=parseExp();
              accept(Sym.TparentesisFinal);
              accept(Sym.TpuntoYcoma);
              s=ssop;
          }
          else if (token_actual.tipo == Sym.Texit)
          {
              AST_Statement_SE sse = new AST_Statement_SE();
              sigToken();
              accept(Sym.TparentesisInicio);
              if(token_actual.tipo==Sym.TintLiteral)
              sse.Int_Lit=Integer.parseInt(token_actual.lexema.toString());
              accept(Sym.TintLiteral);
          //acepte un numero cualquiera.... la otra manera era agregando el 0 por separado al SYM
               accept(Sym.TparentesisFinal);
               accept(Sym.TpuntoYcoma);
               s=sse;
          }
          else throw new ParserException("Error en el analisis sintactico. Se esperaba un statement, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      }
      else if (token_actual.tipo == Sym.TparentesisInicio)
      {
          AST_Statement_SIR ssir = new AST_Statement_SIR();
          sigToken();
          ssir.N_Type=parseType();
          accept(Sym.TparentesisFinal);
          accept(Sym.Tsystem);
          accept(Sym.Tpunto);
          accept(Sym.Tin);
          accept(Sym.Tpunto);
          accept(Sym.Tread);
          accept(Sym.TparentesisInicio);
          accept(Sym.TparentesisFinal);
          accept(Sym.TpuntoYcoma);
          s=ssir;
      }
      else if (token_actual.tipo == Sym.Tidentifier)
      {
          String id2 = token_actual.lexema.toString();
          sigToken();
          if ((token_actual.tipo == Sym.TcorcheteInicio)||(token_actual.tipo == Sym.Tigual))
          {
              AST_Statement_Asign_Compuesto sac = new AST_Statement_Asign_Compuesto();
              AST_Statement_Asign sa = new AST_Statement_Asign();

          if (token_actual.tipo == Sym.TcorcheteInicio)
          {
            sac.N_Exp=parseExp();
            sac.id = id2;
            accept(Sym.TcorcheteFinal);
          }
          accept(Sym.Tigual);
          if (sac.id == null)
          {
          sa.N_Final_Exp=parseExp();
          sa.id=id2;
          s = sa;
          }
          else
          {
            sac.N_Final_Exp=parseExp();
          s = sac;  
          }
          accept(Sym.TpuntoYcoma);
          }
          else
          {
              AST_Statement_Id_Id SII = new AST_Statement_Id_Id();
              SII.id=id2;
              accept(Sym.Tpunto);
              SII.id2=token_actual.lexema.toString();
              accept(Sym.Tidentifier);
              accept(Sym.TparentesisInicio);
              SII.Expl_final=parseExplist();
              accept(Sym.TparentesisFinal);
              accept(Sym.TpuntoYcoma);
              s=SII;
          }
      }
      else if (token_actual.tipo == Sym.Tthis)
      {
          sigToken();
          AST_Statement_This SII = new AST_Statement_This();
              accept(Sym.Tpunto);
              SII.id=token_actual.lexema.toString();
              accept(Sym.Tidentifier);
              accept(Sym.TparentesisInicio);
              SII.N_ExpList=parseExplist();
              accept(Sym.TparentesisFinal);
              accept(Sym.TpuntoYcoma);
              s=SII;
      }
      else
           throw new ParserException("Error en el analisis sintactico. Se esperaba un statement, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");

      return s;
      
  }
    
  public AST_Exp parseExp() throws ParserException
  {
      AST_Exp Ex = null;
      AST_ExpSimpl ExS = parseExpSimpl();
      AST_Exp_TerminalBody ExT = null;

      while (((token_actual.tipo > 29) && (token_actual.tipo < 42)) || (token_actual.tipo == Sym.TcorcheteInicio) || (token_actual.tipo == Sym.Tpunto))
      {
       AST_Exp_TerminalBody expT = null;

      if ((token_actual.tipo > 29) && (token_actual.tipo < 42))
      {
          AST_Exp_Op eo = new AST_Exp_Op();

          AST_Op operador = new AST_Op();
          operador.Num_Op = token_actual.tipo;
          eo.N_Op = operador;
          sigToken();
          eo.N_Exp = parseExp();
          
          expT = eo;

      }
      else if (token_actual.tipo == Sym.TcorcheteInicio)
          {
          AST_Exp_Exp ee = new AST_Exp_Exp();
          sigToken();
          ee.N_Exp2 = parseExp();
          accept(Sym.TcorcheteFinal);
          expT = ee;
      }
      else if (token_actual.tipo == Sym.Tpunto)
      {
          sigToken();
          if (token_actual.tipo == Sym.Tlength)
          {
              AST_Exp_Length el = new AST_Exp_Length();
              sigToken();
              expT = el;
          }
          else if (token_actual.tipo == Sym.Tidentifier)
          {
              AST_Exp_Id ei = new AST_Exp_Id();
              ei.id = token_actual.lexema.toString();
              sigToken();
              accept(Sym.TparentesisInicio);
              ei.N_ExpList = parseExplist();
              accept(Sym.TparentesisFinal);
              expT = ei;
          }
          else
             throw new ParserException("Error en el analisis sintactico. Se esperaba un identificador o length, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      }

       if (ExT == null)
           ExT = expT;
       else
       {
           ExT = new AST_Exp_TerminalBody_Lista(ExT, expT);
       }

      }

      if (ExT == null)
      {
          Ex = ExS;
      }
      else
      {
          Ex = new AST_Exp_Terminal(ExS, ExT);
      }
      return Ex;

  }
  
  
  public AST_ExpSimpl parseExpSimpl() throws ParserException
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
             throw new ParserException("Error en el analisis sintactico. Se esperaba una un entero o identificador, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");

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
          throw new ParserException("Error en el analisis sintactico. Se esperaba una expresión, en su lugar viene " + errores(token_actual.tipo) + " en fila " + token_actual.fila + " y columna " + token_actual.columna + ".");
      
      return Ex;

  }
    
  public AST_ExpList parseExplist() throws ParserException
  {
      AST_ExpList el = null;
      AST_ExpList_Simple els = new AST_ExpList_Simple();
      if ((token_actual.tipo == Sym.TintLiteral)||(token_actual.tipo == Sym.Ttrue)||(token_actual.tipo == Sym.Tfalse)||(token_actual.tipo == Sym.Tidentifier)||
              (token_actual.tipo == Sym.Tthis)||(token_actual.tipo == Sym.Tnew)||(token_actual.tipo == Sym.Tdiferente)||(token_actual.tipo == Sym.TparentesisInicio)||
              (token_actual.tipo == Sym.TstringConstant))
      {
          
      els.N_Exp=parseExp();
      el = els;
      while(token_actual.tipo == Sym.Tcoma)
      {
          sigToken();
          AST_ExpList_Simple t= new AST_ExpList_Simple();
          t.N_Exp=parseExp();
          AST_ExpList_Lista ell = new AST_ExpList_Lista();
          ell.N=el;
          ell.sig=t;
          el = ell;
      }
      }
      return el;
  }
    
  public AST_Op parseOp() throws ParserException
  {
      AST_Op o= new AST_Op();
      o.Num_Op = token_actual.tipo;
     return o;
      /*if (token_actual.tipo == 30)
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
       * *
       */
  }
  
  

  
  public static AST main(java.io.InputStream stream)
  {
      AST arbol = null;
    try
    {
    scanner = new Scanner(stream);
    Parser p = new Parser();
    arbol = p.parse();
    }
    catch(ParserException e)
    {System.out.println(e);}

    return arbol;
    
  
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
