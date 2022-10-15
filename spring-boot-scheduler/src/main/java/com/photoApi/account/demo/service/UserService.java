package com.photoApi.account.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.photoApi.account.demo.dao.UserDao;
import com.photoApi.account.demo.model.User;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	// schedule a job to add object in db (every 5 sec)

	@Scheduled(fixedRate = 5000) // run in each 5 sec.
	public void addToDBJob() {
		User user = new User();
		user.setName("Tushar" + new Random().nextInt(374483));
		userDao.save(user);
		System.out.println("add service call in " + new Date().toString());
	}

	@Scheduled(cron = "0/15 * * * * *") // it will be execute in every 15sec.
	public void fetchDBJob() {
		List<User> users = userDao.findAll();
		System.out.println("fetch service call in " + new Date().toString());
		System.out.println("no of records fetched " + users.size());
		log.info("users : {}", users);
	}

}
