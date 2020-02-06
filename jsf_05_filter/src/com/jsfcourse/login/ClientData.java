package com.jsfcourse.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.UserDAO;
import entities.User;

@Named("clientData")
@SessionScoped
public class ClientData implements Serializable{
	private User client;
	@Inject
	UserDAO userDAO;
	
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
}
