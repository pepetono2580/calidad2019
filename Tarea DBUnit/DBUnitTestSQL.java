package com.mayab.calidad.DBUnit;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mayab.calidad.mockito.dao.Alumno;
import com.mayab.calidad.mockito.dao.ClassAlumnoMap;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DBUnitTestSQL extends DBTestCase{
	
	public DBUnitTestSQL(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/calidad"
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "calidadUser");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "changoleon01");
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		IDatabaseConnection conn = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(conn, getDataSet());
		}finally {
			conn.close();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void testInsert() throws Exception {
		IDatabaseConnection conn = getConnection();
		Alumno alumno = new Alumno("Jose", "Rasgado", 1, 21, 9.3);
		ClassAlumnoMap functions = new ClassAlumnoMap();
		functions.addAlumno(alumno);
		assertEquals(1, conn.getRowCount("Alumnia"));
		conn.close();
	}*/
	
	/*@Test
	public void testDelete() throws Exception{
		IDatabaseConnection conn = getConnection();
		Alumno alumno = new Alumno("Jose", "Rasgado", 2, 21, 9.3);
		ClassAlumnoMap functions = new ClassAlumnoMap();
		functions.removeAlumno(alumno);
		assertEquals(0, conn.getRowCount("Alumnia"));
		conn.close();
	}*/
	
	/*@Test
	public void testUpdateAvg() throws Exception{
		Alumno alumno = new Alumno("Jose", "Rasgado", 2, 21, 9.5);
		ClassAlumnoMap functions = new ClassAlumnoMap();
		functions.updatePromedio(alumno);
		
		IDataSet connection = getConnection().createDataSet();
		ITable actualTable = connection.getTable("Alumnia");
		InputStream xmlFile = getClass().getResourceAsStream("/expected.xml");
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(xmlFile);
	    ITable expectedTable = expectedDataSet.getTable("Alumnia");
		
		Assertion.assertEquals(expectedTable, actualTable);
	}*/
	
	@Test
	public void testGetAlumno()throws Exception{
		IDatabaseConnection conn = getConnection();
		int alumno = 2;
		ClassAlumnoMap functions = new ClassAlumnoMap();
		String test = functions.getAlumno(alumno);
		assertEquals("Query made", test);
		conn.close();
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		InputStream xmlFile = getClass().getResourceAsStream("/alm.xml");
		return new FlatXmlDataSetBuilder().build(xmlFile);
	}

}