package admin;

public class AdminDTO {
	
	private int aId;
	private String aUserId;
	private String aName;
	private String aPassword;
	
	public AdminDTO() {}

	public AdminDTO(int aId, String aUserId, String aName, String aPassword) {
		super();
		this.aId = aId;
		this.aUserId = aUserId;
		this.aName = aName;
		this.aPassword = aPassword;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaUserId() {
		return aUserId;
	}

	public void setaUserId(String aUserId) {
		this.aUserId = aUserId;
	}
	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	@Override
	public String toString() {
		return "AdminDTO [aId=" + aId + ", aUserId=" + aUserId + ", aName=" + aName + ", aPassword=" + aPassword + "]";
	}
	
}
