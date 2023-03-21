package com.blogapp.vlog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	
	
	private int id;
	
	@NotEmpty
	@Size(min=4,message="user name be>=4 characters")
	private String name;
	@Email(message = "please enter a valid Id")
	private String user_email;
	@NotEmpty
	@Size(min = 5,max=10,message ="Password must be min >=5 or<=10")
	//@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{5,10}$",
	//message="Password must be min >=5 or<=10 also atleast one uppercase,lower case ,special charac,number with no space and min of5 maxto 10 characters")//regex for atleast one uppercase,lower case ,special charac,number
	private String user_password;                                                                //no space and min of5 maxto 10 characters 
	@NotNull
	private String about_user;

}
