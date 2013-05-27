package br.com.tcc.principal;

import java.awt.Image;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.ImageUtilities;

/**
 *
 * @author Renan
 */
public class RootNode extends AbstractNode {

    public RootNode(Children children) {
        super(children);
    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage("");
    }

    
}
