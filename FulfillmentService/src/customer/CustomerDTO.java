package customer;

public class CustomerDTO {
	
	private int cId;
	private String cUserId;
	private String cName;
	private String cPassword;
	
	public CustomerDTO(int cId, String cUserId, String cName, String cPassword) {
		super();
		this.cId = cId;
		this.cUserId = cUserId;
		this.cName = cName;
		this.cPassword = cPassword;
	}
	
	public CustomerDTO(String cUserId, String cName, String cPassword) {
		super();
		this.cUserId = cUserId;
		this.cName = cName;
		this.cPassword = cPassword;
	}
	
	public CustomerDTO() {}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcUserId() {
		return cUserId;
	}

	public void setcUserId(String cUserId) {
		this.cUserId = cUserId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	@Override
	public String toString() {
		return "CustomerDTO [cId=" + cId + ", cUserId=" + cUserId + ", cName=" + cName + ", cPassword=" + cPassword
				+ "]";
	}
}
