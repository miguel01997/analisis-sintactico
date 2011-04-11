package Sintactico.Exceptions;

import javax.swing.JOptionPane;

public class ScannerException extends Exception
{
  public ScannerException(String mensaje)
  {
   super(mensaje);
   JOptionPane.showMessageDialog(null, mensaje, "Scanner Error", 0);
  }
  public ScannerException(String mensaje, int tipo, String titulo)
  {
   super(mensaje);
   JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);
  }
}