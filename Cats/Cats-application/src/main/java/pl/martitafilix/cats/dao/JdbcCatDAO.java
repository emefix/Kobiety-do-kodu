package pl.martitafilix.cats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.martitafilix.cats.model.Cat;

@Repository
public class JdbcCatDAO implements CatDAO {

	@Autowired
	private DataSource dataSource;
	
	private String 				sql;
	private Connection 			conn;
	private PreparedStatement	ps;
	private ResultSet 			rs;
    
	public JdbcCatDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	/*
	 * public void setDataSource(DataSource dataSource) { 
	 * 		this.dataSource = dataSource; }
	 */
	
	@Override
	public List<Cat> getCats() {
		
		List<Cat> cats = new ArrayList<Cat>();
		
		sql = "SELECT * FROM cats";
		conn = null;
		
		try {
			conn 	= dataSource.getConnection();
			ps 		= conn.prepareStatement(sql);
//			Statement 			s 	= conn.createStatement();
			
			rs 	= ps.executeQuery();
//			ResultSet rs1 	= ps.executeQuery(sqlSelect);

			while (rs.next()) {
				Cat cat = getCatFromDB(rs);
				cats.add(cat);
			}
			rs.close();
			ps.close();
			
			return cats;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void addCat(Cat cat) {

		sql = "INSERT INTO cats(name, date_of_birth, weight, name_of_catKeeper)"
				+ " VALUES (?, ?, ?, ?)";
		conn = null;
		
		try {
			conn 	= dataSource.getConnection();
			ps 		= conn.prepareStatement(sql);
			
			ps.setString(1, cat.getName());
			ps.setDate	(2, new java.sql.Date(cat.getDate_of_birth().getTime()));
			ps.setFloat	(3, cat.getWeight());
			ps.setString(4, cat.getName_of_catKeeper());
			
			ps.executeUpdate();
//			ps.execute()
			System.out.println("Added a new cat to database!");

			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public Cat getCatById(Integer id) {

		sql = "SELECT * FROM cats WHERE id = ?";
		conn = null;
		
		try {
			conn 	= dataSource.getConnection();
			ps 		= conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			Cat cat = null;
			
			rs = ps.executeQuery();

			if (rs.next()) {
				cat = this.getCatFromDB(rs);
			}
			rs.close();
			ps.close();
			
			return cat;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	private Cat getCatFromDB(ResultSet rs) throws SQLException {
		
		Integer	id 			= rs.getInt("id");
		String	name		= rs.getString("name");
		Date	date		= rs.getDate("date_of_birth");
		Float	weight		= rs.getFloat("weight");
		String	catKeeper 	= rs.getString("name_of_catKeeper");
		
		Cat cat = new Cat(id, name, date, weight, catKeeper);
		return cat;
	}
}
