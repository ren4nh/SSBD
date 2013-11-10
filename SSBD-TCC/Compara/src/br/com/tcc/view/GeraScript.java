/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "br.com.tcc.principal.GeraScript")
@ActionRegistration(
        iconBase = "br/com/tcc/view/doc-script.gif",
        displayName = "#CTL_GeraScript")
@ActionReferences({
    @ActionReference(path = "Menu/Comparar", position = 1000),
    @ActionReference(path = "Toolbars/File", position = -200)
})
@Messages("CTL_GeraScript=Gerar Script de Sincronização")
public final class GeraScript implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        PrintWriter pw = null;
        boolean erro = false;
        ComparaTopComponent c = ComparaTopComponent.getInstance();
        if (c != null) {
            try {
                JFileChooser j = new JFileChooser();
                j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int resp = j.showOpenDialog(j);
                if (resp != JFileChooser.APPROVE_OPTION) {
                    return;
                }
                File salvo = j.getSelectedFile();
                if (!salvo.getAbsolutePath().endsWith(".sql")) {
                    salvo = new File(salvo.getAbsolutePath() + ".sql");
                }
                String script = c.geraScript();
                if (!script.trim().isEmpty()) {
                    pw = new PrintWriter(new FileWriter(salvo), true);
                    pw.println(script);
                    pw.close();
                    c.close();
                } else {
                    erro = true;
                    c.close();
                }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
            if (!erro) {
                JOptionPane.showMessageDialog(null, "Script gerado com sucesso !");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado !!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Deverá ser feita uma comparação antes !");
        }
    }
}
