/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.penagihan.dao;

import com.artivisi.penagihan.domain.PenagihanService;
import java.io.File;
import java.sql.Connection;
import javax.sql.DataSource;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author jimmy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:com/artivisi/**/applicationContext.xml")
public class MenuDaoTest {

    @Autowired
    private DataSource dataSource;

    @Before
    public void hapusDataTest() throws Exception {
        IDataSet[] daftarDataset = new IDataSet[]{
            new FlatXmlDataSetBuilder()
            .build(new File("src/test/resources/dbunit/menu.xml"))
        };

        Connection conn = dataSource.getConnection();

        // untuk oracle, harus pakai skema
		/*
         DatabaseOperation.CLEAN_INSERT.execute
         (new DatabaseConnection(conn, "skema"),
         new CompositeDataSet(daftarDataset));
         */

        // non oracle, tidak pakai skema
        DatabaseOperation.CLEAN_INSERT.execute(new DatabaseConnection(conn),
                new CompositeDataSet(daftarDataset));

        conn.close();
    }
    
    @Test
    public void test() {
        System.out.println("print menu");
    }
}
