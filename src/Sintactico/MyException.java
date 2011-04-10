package Sintactico;
import javax.swing.JOptionPane;

public class MyException extends Exception
{
  public MyException(String mensaje)
  {
   super(mensaje);
   JOptionPane.showMessageDialog(null, mensaje, "Error Sintáctico", 0);
  }
  public MyException(String mensaje, int tipo, String titulo)
  {
   super(mensaje);
   JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);
  }
}