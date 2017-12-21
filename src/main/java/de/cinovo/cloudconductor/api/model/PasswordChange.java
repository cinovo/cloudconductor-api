package de.cinovo.cloudconductor.api.model;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
public class PasswordChange {
	
	private String oldPassword;
	private String newPassword;
	private String userName;
	
	
	/**
	 * Create new password change object
	 */
	public PasswordChange() {
		
	}
	
	/**
	 * @param oldPw the old password
	 * @param newPw the new password to be set
	 * @param userName the user for whom the password should be changed
	 */
	public PasswordChange(String oldPw, String newPw, String userName) {
		this.oldPassword = oldPw;
		this.newPassword = newPw;
		this.userName = userName;
	}
	
	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return this.oldPassword;
	}
	
	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return this.newPassword;
	}
	
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
