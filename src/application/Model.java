package application;

import java.util.ArrayList;

public class Model {
	
	private ArrayList<ArrayList<String>> user_password;
	private String user;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Model () {
		user_password = new ArrayList<ArrayList<String>>();
		user_password.add(new ArrayList<String>());
		user_password.add(new ArrayList<String>());
		user_password.get(0).add("Robin");
		user_password.get(1).add("toto");
		
		
	}
	
    public boolean check_user(String user,String password) {
    	int index = user_password.get(0).indexOf(user);
    	if (index == -1) {
    		return false;
    	}
    	if(user_password.get(1).get(index).equals(password)) {
    		this.user = user;
    		return true;
    	}
    	
        return false;
    }
    
    public boolean add_user (String user, String password) {
    	if (user.isBlank() || password.isBlank()) {
    		return false;
    	}
    	user_password.get(0).add(user);
		user_password.get(1).add(password);
		
		return true;
    }
}
