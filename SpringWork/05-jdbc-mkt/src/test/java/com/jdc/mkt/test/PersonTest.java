package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


@TestMethodOrder(OrderAnnotation.class)
public class PersonTest {

	private static final String URL = "jdbc:mysql://localhost:3306/testbd";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	
	@BeforeEach
	void init() {
		try(
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = con.createStatement();
			){
			
			stmt.executeUpdate("truncate table person");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Order(1)
	@ParameterizedTest
	@DisplayName("1. insert using statement")
	@CsvSource(value = {"Su SU:20","Sandra:43"},delimiter =':')
	void test1(String name,int age) {
		try(
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = con.createStatement();
			){
			
			stmt.executeUpdate(String.format("insert into person (name,age) values ('%s',%d)", name, age));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Order(2)
	@ParameterizedTest
	@DisplayName("2. insert using perparement statement")
	@CsvSource(value = {"Andrew:20","William:43"},delimiter = ':')
	void test2(String name,int age){
		
		String sql = "insert into person(name,age) values (?,?)";
		try(
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = con.prepareStatement(sql);
			){
						
			stmt.setString(1, name);
			stmt.setInt(2, age);
			int res = stmt.executeUpdate();
			assertEquals(1, res);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}













