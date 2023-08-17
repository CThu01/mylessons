package com.jdc.mkt.dao;

import com.jdc.mkt.dto.Category;
import static com.jdc.mkt.utils.PosConnection.getConnection;

import java.awt.Taskbar.State;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements UpdateService<Category>,ReferenceServices<Category>{

	

	@Override
	public int insert(Category c) {
		
		String sql = "insert into category (name) values (?)";
		
		try(
			var con = getConnection();
			var stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)
			){
			
			stmt.setString(1, c.getName());
			stmt.executeUpdate();
			
			var rs = stmt.getGeneratedKeys();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int update(Category t) {
		
		String sql = "update category set name=? where id=?";
		
		try(
			var con = getConnection();
			var stmt = con.prepareStatement(sql)
			){
			
			
			stmt.setString(1, t.getName());
			stmt.setInt(2, t.getId());
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int delete(int id) {
		
		String sql = "delete from category where id=?";
		
		try(
			var con = getConnection();
			var stmt = con.prepareStatement(sql)
			){
			
			
			stmt.setInt(1, id);
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public Category findById(int id) {
		
		String sql = "select * from category where id=?";
		
		try(
			var con = getConnection();
			var stmt = con.prepareStatement(sql)
			){
			
			
			stmt.setInt(1, id);
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				var cat = new Category();
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				return cat;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<Category> findByNameLike(String name) {

		List<Category> list = new ArrayList<Category>();
		String sql = "select * from category where name like ?";
		
		
		try(
			var con = getConnection();
			var stmt = con.prepareStatement(sql)
			){
			
			
			stmt.setString(1, name.concat("%"));
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				var cat = new Category();
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				list.add(cat);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;

		
	} 
	
	
}










