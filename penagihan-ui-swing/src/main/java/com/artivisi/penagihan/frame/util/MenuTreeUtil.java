/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.penagihan.frame.util;

import com.artivisi.penagihan.domain.Menu;
import com.artivisi.penagihan.domain.PenagihanService;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author jimmy
 */
public class MenuTreeUtil {
    
    private static final String ACCOUNT_LEVEL = "1";

    public static JTree getTreeFromDataBase(List<Menu> data) {
        javax.swing.JTree tree = new javax.swing.JTree();
        DefaultMutableTreeNode topNode = new DefaultMutableTreeNode();

        DefaultMutableTreeNode rootNode;
        DefaultMutableTreeNode childNode;

        int i = 0;
        for (Menu mc : data) {
            if (mc.getLevelMenu().equals(ACCOUNT_LEVEL)) {
                String a = String.valueOf(mc.getNomer().charAt(0));
                rootNode = new DefaultMutableTreeNode(mc.getNomer());
            }

            i++;
        }
        return tree;
    }

    public static DefaultTreeModel constructTree(PenagihanService penagihanService) {
        List<Menu> lst = penagihanService.getParent();
        DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode();
        
        for (Menu ma : lst) {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(ma);
            List<Menu> subChild = penagihanService.getTreeNode(ma);
            getChildTree(child, subChild, penagihanService);
            dmtn.add(child);
        }
        
        return new DefaultTreeModel(dmtn);
    }

    private static DefaultMutableTreeNode getChildTree(final DefaultMutableTreeNode parent,
            final List<Menu> subChild, PenagihanService penagihanService) { 
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode();

        for (Menu subMa : subChild) { //253
            DefaultMutableTreeNode sub = new DefaultMutableTreeNode(subMa);
            List<Menu> listChild = penagihanService.getTreeNode(subMa);
            getChildTree(sub, listChild, penagihanService);
            parent.add(sub);
        }
        
        treeNode.add(parent);

        return treeNode;
    }
    
}
