package gamerscreed.rocketstats.model.beans;

import java.io.Serializable;

public class PlayerViewBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String _roleName;
	private String _userName;
	private String _userToken;
	private String _fullName;
	
	
	public PlayerViewBean() { }
	
	public PlayerViewBean(String userName)
	{
		_userName = userName;
	}
	
	public PlayerViewBean(String userName, String userToken)
	{
		_userName = userName;
		_userToken = userToken;
	}
	
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getRoleName() {
		return _roleName;
	}
	
	public void setRoleName(String roleName) {
		this._roleName = roleName;
	}
	
	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		this._userName = userName;
	}
	
	public String getFullName() {
		return _fullName;
	}
	
	public void setFullName(String fullName) {
		this._fullName = fullName;
	}

	public String getUserToken() {
		return _userToken;
	}

	public void setUserToken(String userToken) {
		this._userToken = userToken;
	}
	
}
