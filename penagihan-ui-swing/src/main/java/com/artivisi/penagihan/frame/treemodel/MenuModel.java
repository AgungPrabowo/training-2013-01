/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.penagihan.frame.treemodel;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author jimmy
 */
public class MenuModel extends DefaultTreeModel {

    public MenuModel(TreeNode root) {
        super(root);
    }

    @Override
    public void insertNodeInto(MutableTreeNode newChild, MutableTreeNode parent, int index) {
        
    }
    
    
}
