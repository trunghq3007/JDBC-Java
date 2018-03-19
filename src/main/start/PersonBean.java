/**
 * 
 */
package main.start;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

/**
 * @description:
 * @author: Admin
 * @time: 10:21:47 AM
 * @date: Mar 19, 2018
 */
public class PersonBean {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/csd-rdc?autoReconnect=true&useSSL=false";
	static final String DB_USER = "root";
	static final String DB_PASS = "123654";
	private JdbcRowSet rowSet = null;

	public PersonBean() {
		try {
			Class.forName(JDBC_DRIVER);
			rowSet = new JdbcRowSetImpl();
			rowSet.setUrl(DB_URL);
			rowSet.setUsername(DB_USER);
			rowSet.setPassword(DB_PASS);
			rowSet.setCommand("SELECT * FROM Person");
			rowSet.execute();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public Person create(Person p) {
		try {
			rowSet.moveToInsertRow();
			rowSet.updateInt("personId", p.getPersonId());
			rowSet.updateString("firstName", p.getFirstName());
			rowSet.updateString("middleName", p.getMiddleName());
			rowSet.updateString("lastName", p.getLastName());
			rowSet.updateString("email", p.getEmail());
			rowSet.updateString("phone", p.getPhone());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
		} catch (SQLException ex) {
			try {
				rowSet.rollback();
				p = null;
			} catch (SQLException e) {

			}
			ex.printStackTrace();
		}
		return p;
	}

	public Person update(Person p) {
		try {
			rowSet.updateString("firstName", p.getFirstName());
			rowSet.updateString("middleName", p.getMiddleName());
			rowSet.updateString("lastName", p.getLastName());
			rowSet.updateString("email", p.getEmail());
			rowSet.updateString("phone", p.getPhone());
			rowSet.updateRow();
			rowSet.moveToCurrentRow();
		} catch (SQLException ex) {
			try {
				rowSet.rollback();
			} catch (SQLException e) {

			}
			ex.printStackTrace();
		}
		return p;
	}

	public void delete() {
		try {
			rowSet.moveToCurrentRow();
			rowSet.deleteRow();
		} catch (SQLException ex) {
			try {
				rowSet.rollback();
			} catch (SQLException e) {
			}
			ex.printStackTrace();
		}

	}

	public Person moveFirst() {
		Person p = new Person();
		try {
			rowSet.first();
			p.setPersonId(rowSet.getInt("personId"));
			p.setFirstName(rowSet.getString("firstName"));
			p.setMiddleName(rowSet.getString("middleName"));
			p.setLastName(rowSet.getString("lastName"));
			p.setEmail(rowSet.getString("email"));
			p.setPhone(rowSet.getString("phone"));

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return p;
	}

	public Person moveLast() {
		Person p = new Person();
		try {
			rowSet.last();
			p.setPersonId(rowSet.getInt("personId"));
			p.setFirstName(rowSet.getString("firstName"));
			p.setMiddleName(rowSet.getString("middleName"));
			p.setLastName(rowSet.getString("lastName"));
			p.setEmail(rowSet.getString("email"));
			p.setPhone(rowSet.getString("phone"));

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return p;
	}

	public Person moveNext() {
		Person p = new Person();
		try {
			if (rowSet.next() == false)
				rowSet.previous();
			p.setPersonId(rowSet.getInt("personId"));
			p.setFirstName(rowSet.getString("firstName"));
			p.setMiddleName(rowSet.getString("middleName"));
			p.setLastName(rowSet.getString("lastName"));
			p.setEmail(rowSet.getString("email"));
			p.setPhone(rowSet.getString("phone"));

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return p;
	}

	public Person movePrevious() {
		Person p = new Person();
		try {
			if (rowSet.previous() == false)
				rowSet.next();
			p.setPersonId(rowSet.getInt("personId"));
			p.setFirstName(rowSet.getString("firstName"));
			p.setMiddleName(rowSet.getString("middleName"));
			p.setLastName(rowSet.getString("lastName"));
			p.setEmail(rowSet.getString("email"));
			p.setPhone(rowSet.getString("phone"));

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return p;
	}

	public Person getCurrent() {
		Person p = new Person();
		try {
			rowSet.moveToCurrentRow();
			p.setPersonId(rowSet.getInt("personId"));
			p.setFirstName(rowSet.getString("firstName"));
			p.setMiddleName(rowSet.getString("middleName"));
			p.setLastName(rowSet.getString("lastName"));
			p.setEmail(rowSet.getString("email"));
			p.setPhone(rowSet.getString("phone"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return p;
	}
}
