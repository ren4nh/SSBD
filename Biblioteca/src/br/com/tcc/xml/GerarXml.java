package br.com.tcc.xml;

import br.com.tcc.bean.Alter;
import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.Create;
import br.com.tcc.bean.Delete;
import br.com.tcc.bean.Tabela;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renan
 */
public class GerarXml {

    public static String gerarCreate(Create create) {
        String xml = "";
        try {
            XStream xstream = new XStream(new DomDriver("UTF-8"));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            xstream.alias("create", Create.class);
            xstream.alias("tabela", Tabela.class);
            xstream.alias("coluna", Coluna.class);
            xstream.autodetectAnnotations(true);
            writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
            xstream.toXML(create, writer);
            xml = outputStream.toString("UTF-8");
            salvar(xml, "create.xml");
        } catch (IOException ex) {
            Logger.getLogger(GerarXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xml;
    }
    
    public static String gerarDelete(Delete delete) {
         String xml = "";
        try {
            XStream xstream = new XStream(new DomDriver("UTF-8"));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            xstream.alias("delete", Delete.class);
            xstream.alias("tabela", Tabela.class);
            xstream.autodetectAnnotations(true);
            writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
            xstream.toXML(delete, writer);
            xml = outputStream.toString("UTF-8");
            salvar(xml, "delete.xml");
        } catch (IOException ex) {
            Logger.getLogger(GerarXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xml;
    }
    
     public static String gerarAlter(Alter alter) {
        String xml = "";
        try {
            XStream xstream = new XStream(new DomDriver("UTF-8"));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            xstream.alias("alter", Alter.class);
            xstream.alias("tabela", Tabela.class);
            xstream.alias("coluna", Coluna.class);
            xstream.autodetectAnnotations(true);
            writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
            xstream.toXML(alter, writer);
            xml = outputStream.toString("UTF-8");
            salvar(xml, "alter.xml");
        } catch (IOException ex) {
            Logger.getLogger(GerarXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xml;
    }

    private static void salvar(String xml, String nome) {
        try {
            File file = new File(nome);
            if (file.exists()) {
                file.delete();
            } else {
                file = new File(nome);
            }
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(xml.getBytes());
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(GerarXml.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
