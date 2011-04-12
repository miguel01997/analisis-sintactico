/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Editor;

/**
 *
 * @author lidier
 */
import java.awt.Event;
import javax.swing.AbstractAction;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import javax.swing.Action;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;


public class AccionAnalizar extends AbstractAction
{
    private JTextComponent areaTexto;

    public void actionPerformed (ActionEvent e)
   {
           String texto = areaTexto.getText();
      InputStream stream = new ByteArrayInputStream(texto.getBytes());
      Sintactico.Parser.Parser.main(stream);
   }

    public AccionAnalizar(JTextComponent areaTexto)
    {
        this.areaTexto = areaTexto;
        this.putValue(Action.NAME, "COMPILAR");
        this.putValue(
            Action.ACCELERATOR_KEY,
            KeyStroke.getAWTKeyStroke('E', Event.CTRL_MASK));
    }


}
