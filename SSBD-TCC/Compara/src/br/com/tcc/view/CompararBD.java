/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "br.com.tcc.view.CompararBD")
@ActionRegistration(
        displayName = "#CTL_CompararBD")
@ActionReference(path = "Menu/File", position = 1200)
@Messages("CTL_CompararBD=Comparar BD...")
public final class CompararBD implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
       ComparaTopComponent c = new ComparaTopComponent();
       c.open();
       c.requestActive();
    }
}
