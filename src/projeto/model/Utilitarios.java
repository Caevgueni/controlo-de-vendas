
package projeto.model;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;


public class Utilitarios {
    
    // metodo limparcampos
    public void LimparTela(JPanel container){ //imformamos p painel aonde estao localizados os campos que pretendenmos lipar
        Component components[]= container.getComponents();
        for (Component component: components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);// ele vai precorer cada campo i vai setar o texto pa null 
            }
        }
    }
    
}
