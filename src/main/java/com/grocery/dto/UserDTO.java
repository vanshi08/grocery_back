package com.grocery.dto;


import javax.validation.constraints.NotEmpty;

	public class UserDTO {
		
		@SuppressWarnings("unused")
		private int userId;
		
		private String email;
		private Long mobileNumber;
		
		public int getUserId() {
			return userId;
		}

		
		@Override
		public String toString() {
			return "UserDTO [userId=" + userId + ", email=" + email + ", mobileNumber=" + mobileNumber + ", userName="
					+ userName + ", password=" + password + "]";
		}

	
		public UserDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserDTO(int userId, String email, Long mobileNumber, String userName,
				@NotEmpty(message = "password is required") String password) {
			super();
			this.userId = userId;
			this.email = email;
			this.mobileNumber = mobileNumber;
			this.userName = userName;
			this.password = password;
		}

		private String userName;
		
		@NotEmpty(message = "password is required")
		private String password;
				
		

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Long getMobileNumber() {
			// TODO Auto-generated method stub
			return this.mobileNumber;
		}

		public String getEmail() {
			// TODO Auto-generated method stub
			return this.email;
		}

		

	}


