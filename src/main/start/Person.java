/**
 * 
 */
package main.start;

/**
 * @description:
 * @author: Admin
 * @time: 10:19:45 AM
 * @date: Mar 19, 2018
 */
public class Person {
	private int personId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phone;

	Person() {
		

	}

	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 19, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 19, 2018
	 * @exception:
	 * @param personId
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 * @param phone
	 */
	public Person(int personId, String firstName, String middleName, String lastName, String email, String phone) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
