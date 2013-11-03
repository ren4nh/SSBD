/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.service;

import br.com.tcc.view.ComparaTopComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "br.com.tcc.service.Comparar")
@ActionRegistration(
        iconBase = "br/com/tcc/service/database.png",
        displayName = "#CTL_Comparar")
@ActionReferences({
    @ActionReference(path = "Menu/Comparar", position = 800),
    @ActionReference(path = "Toolbars/File", position = -400)
})
@Messages("CTL_Comparar=Comparar BD")
public final class Comparar implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ComparaTopComponent c = new ComparaTopComponent();
        c.open();
        c.requestActive();
    }
}
