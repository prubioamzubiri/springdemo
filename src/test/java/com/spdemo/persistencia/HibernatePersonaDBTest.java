package com.spdemo.persistencia;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.nullable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import static org.dbunit.Assertion.assertEqualsIgnoreCols;

import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;


import org.h2.jdbcx.JdbcDataSource;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HibernatePersonaDBTest extends DataSourceBasedDBTestCase{

    @Override
    protected DataSource getDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:default;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:schema.sql'");
        dataSource.setUser("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(getClass().getClassLoader().getResourceAsStream("data.xml"));
    }

    @Override
    protected DatabaseOperation getSetUpOperation() {
        return DatabaseOperation.REFRESH;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() {
        return DatabaseOperation.DELETE_ALL;
    }
    
    // @Test
    // public void givenDataSetEmptySchema_whenDataSetCreated_thenTablesAreEqual() throws Exception {
    //     IDataSet expectedDataSet = getDataSet();
    //     ITable expectedTable = expectedDataSet.getTable("CLIENTS");
    //     IDataSet databaseDataSet = getConnection().createDataSet();
    //     ITable actualTable = databaseDataSet.getTable("CLIENTS");
    //     assertEquals(expectedTable, actualTable);
    // }

    @Test
    public void givenDataSet_whenInsert_thenTableHasNewClient() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("expected-user.xml")) {
            IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(is);
            ITable expectedTable = expectedDataSet.getTable("CLIENTS");
            Connection conn = getDataSource().getConnection();

            conn.createStatement()
                .executeUpdate(
                "INSERT INTO CLIENTS (first_name, last_name) VALUES ('John', 'Jansen')");
            ITable actualData = getConnection()
                .createQueryTable(
                    "result_name",
                    "SELECT * FROM CLIENTS WHERE last_name='Jansen'");

            assertEqualsIgnoreCols(expectedTable, actualData, new String[] { "id" });
        }
    }

}
