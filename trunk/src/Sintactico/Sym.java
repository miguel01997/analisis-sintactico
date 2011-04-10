/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico;

/**
 *
 * @author lidier
 */
public class Sym {


    public static final int Teof = 0;//Modificacion
    
    public static final int Timport = 1;
    public static final int Tclass = 2;
    public static final int Tpublic = 3;
    public static final int Tstatic = 4;
    public static final int Tvoid = 5;
    public static final int Tmain = 6;
    public static final int Tstring = 7;
    public static final int Tigual = 8;
    public static final int Textends= 9;
    public static final int Timplements = 10;
    public static final int Treturn = 11;
    public static final int Tint = 12;
    public static final int Tboolean = 13;
    public static final int Tif = 14;
    public static final int Telse = 15; 
    public static final int Twhile = 16;
   //se movieron estos valores de aqui para abajo por que se ocupaban subdividir
    public static final int Tlength = 20;
    public static final int TintLiteral = 21;
    public static final int Ttrue = 22;
    public static final int Tfalse = 23;
    public static final int Tthis = 24;
    public static final int Tnew = 25;
    public static final int TstringConstant = 26;
    public static final int Tnegacion = 27;
    public static final int Tidentifier = 28;
    //public static final int Tnum = 29;

    public static final int Tsuma = 30;
    public static final int Tresta = 31;
    public static final int Tdivision = 32;
    public static final int Tmultiplicacion = 33;
    public static final int Tdiferente = 34;
    public static final int Tigualigual = 35;
    public static final int Tmenor = 36;
    public static final int Tmayor = 37;
    public static final int TmenorIgual = 38;
    public static final int TmayorIgual = 39;
    public static final int Tor = 40;
    public static final int Tand = 41;

    public static final int TparentesisInicio = 42;
    public static final int TparentesisFinal = 43;
    public static final int TpuntoYcoma = 44;
    public static final int Tcoma = 45;
    public static final int TcorcheteInicio = 46;
    public static final int TcorcheteFinal = 47;
    //public static final int Ttexto = 47; //para cuando se leen comillas "
    public static final int Tpunto = 49;
    public static final int TllaveInicio = 50;
    public static final int TllaveFinal = 51;


    // system.out.println
    // system.in.read
    // system.exit

    public static final int Tsystem = 52;
    public static final int Tout = 53;
    public static final int Tprintln = 54;
    public static final int Tin = 55;
    public static final int Tread = 56;
    public static final int Texit = 57;


       /*
        * RESPALDO DEL MAIN DEL SCANNER
  public static void main(java.io.InputStream stream) {


        Scanner scanner = null;
        try {
          scanner = new Scanner(stream);
          do {
            System.out.println(scanner.nextToken());
          } while (!scanner.zzAtEOF);

        }

        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }


  }

*/

}
