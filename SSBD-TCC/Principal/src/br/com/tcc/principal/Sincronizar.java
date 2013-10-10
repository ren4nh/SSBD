/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "br.com.tcc.principal.Sincronizar")
@ActionRegistration(
        iconBase = "br/com/tcc/principal/image/Synchronize-icon.png",
        displayName = "#CTL_Sincronizar")
@ActionReferences({
    @ActionReference(path = "Menu/Comparar", position = 900),
    @ActionReference(path = "Toolbars/File", position = -200)
})
@Messages("CTL_Sincronizar=Sincronizar Automaticamente")
public final class Sincronizar implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
