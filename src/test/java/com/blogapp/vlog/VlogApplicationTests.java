package com.blogapp.vlog;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogapp.vlog.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class VlogApplicationTests {

	@Autowired
	private UserRepository userRepo;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void repotest()
	{
		String classname = this.userRepo.getClass().getName();
		String packName = this.userRepo.getClass().getPackage().getName();
		System.out.println("class name is "+classname);
		System.out.println("packagename name is "+packName);
	}
   
}
