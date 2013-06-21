/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.penagihan.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jimmy
 */
@Entity
@Table(name = "m_menu")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false)
    private String nomer;
    
    @Column(name = "nama_menu", nullable = false)
    private String nama;
    
    @Column(nullable = false, name="level_menu")
    private String levelMenu;
    
    @ManyToOne
    @JoinColumn(name="parent", referencedColumnName = "nomer")
    private Menu parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLevelMenu() {
        return levelMenu;
    }

    public void setLevelMenu(String levelMenu) {
        this.levelMenu = levelMenu;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return  nomer + " " + nama;
    }

}