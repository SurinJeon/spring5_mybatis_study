package spring5_mybatis_study.dto;

import java.util.Date;

/**
 * @author surin 
 * 보통 table에서는 학생들~ 이니까 students로 하고, 
 * 해당 객체는 한 명을 이야기하니까 student로 한다
 */
public class Student {
	private int studId;
	private String name;
	private String email;
	private PhoneNumber phone;
	private Date dob;
	private Address address;
	private Gender gender; // p126 enum 만들고 추가한 field
	
	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return String.format("Student [%s, %s, %s, %s, %s, %s, %s]", studId,
				name, email, phone, dob, address, gender == Gender.FEMALE ? "여자" : "남자");
	}

}
