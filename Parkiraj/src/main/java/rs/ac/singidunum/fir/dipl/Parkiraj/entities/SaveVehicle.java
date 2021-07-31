package rs.ac.singidunum.fir.dipl.Parkiraj.entities;

public class SaveVehicle {
	
	private String email;
	
	private String lastname;
	
	private String licensePlateNumber;
	
	private String name;
	
	private String password;
	
	private String phone;
	
	private int userId;
	
	private String username;

	private String vehicleName;

	public String getEmail() {
	return email;
	}

	public void setEmail(String email) {
	this.email = email;
	}

	public String getLastname() {
	return lastname;
	}

	public void setLastname(String lastname) {
	this.lastname = lastname;
	}

	public String getLicensePlateNumber() {
	return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
	this.licensePlateNumber = licensePlateNumber;
	}

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getPassword() {
	return password;
	}

	public void setPassword(String password) {
	this.password = password;
	}

	public String getPhone() {
	return phone;
	}

	public void setPhone(String phone) {
	this.phone = phone;
	}

	public int getUserId() {
	return userId;
	}

	public void setUserId(int userId) {
	this.userId = userId;
	}

	public String getUsername() {
	return username;
	}

	public void setUsername(String username) {
	this.username = username;
	}


	public String getVehicleName() {
	return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
	}

	public SaveVehicle(String email, String lastname, String licensePlateNumber, String name, String password,
			String phone, int userId, String username, String vehicleName) {
		super();
		this.email = email;
		this.lastname = lastname;
		this.licensePlateNumber = licensePlateNumber;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.userId = userId;
		this.username = username;
		this.vehicleName = vehicleName;
	}

	@Override
	public String toString() {
		return "SaveVehicle [email=" + email + ", lastname=" + lastname + ", licensePlateNumber=" + licensePlateNumber
				+ ", name=" + name + ", password=" + password + ", phone=" + phone + ", userId=" + userId
				+ ", username=" + username+ ", vehicleName=" + vehicleName + "]";
	}
	
	


}
