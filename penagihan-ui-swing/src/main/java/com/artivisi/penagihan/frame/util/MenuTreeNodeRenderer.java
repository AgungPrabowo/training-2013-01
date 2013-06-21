/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.penagihan.frame.util;

import com.artivisi.penagihan.domain.Menu;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author jimmy
 */
public class MenuTreeNodeRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        JLabel label = (JLabel) super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        if (value instanceof Menu) {
            Menu menu = (Menu) value;
            label.setText(menu.getNomer());
        } else if (value instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) value;
            if (treeNode.getUserObject() instanceof Menu) {
                Menu menu = (Menu) treeNode.getUserObject();
                label.setText(menu.getNomer() + " " + menu.getNama());
            }
        }
        return label;

    }
}
