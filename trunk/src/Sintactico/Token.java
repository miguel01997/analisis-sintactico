/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sintactico;

/**
 *
 * @author lidier
 */
public class Token {
    public int tipo;
    public int fila;
    public int columna;
    public Object lexema;
    
    public Token (int t, int f, int c)
    {
       tipo = t;
       fila = f;
       columna = c;
       lexema = null;
    }

    public Token (int t, int f, int c, Object o)
    {
       tipo = t;
       fila = f;
       columna = c;
       lexema = o;
    }
}
