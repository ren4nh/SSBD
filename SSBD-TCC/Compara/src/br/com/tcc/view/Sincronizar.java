/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "br.com.tcc.view.Sincronizar")
@ActionRegistration(
        iconBase = "br/com/tcc/view/Synchronize-icon.png",
        displayName = "#CTL_Sincronizar")
@ActionReferences({
    @ActionReference(path = "Menu/Ações", position = 900),
    @ActionReference(path = "Toolbars/File", position = -200)
})
@Messages("CTL_Sincronizar=Sincronizar Automaticamente")
public final class Sincronizar implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ComparaTopComponent c = ComparaTopComponent.getInstance();
        if (c != null) {
            boolean ok = c.syncDb();
            if (ok) {
              JOptionPane.showMessageDialog(null, "Sincronizado !");  
            } else {
               JOptionPane.showMessageDialog(null, "Deverá ser feita uma comparação antes !");  
            }          
            c.close();
        } else {
            JOptionPane.showMessageDialog(null, "Deverá ser feita uma comparação antes !");
        }
    }
}
