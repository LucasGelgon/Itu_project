package application;

import java.io.*;
import java.util.ArrayList;

public class Model {
	
	private ArrayList<ArrayList<String>> user_password;
	private String user;
	private int index_user;
	private ArrayList<ArrayList<Boolean>> answered;
	private ArrayList<Poll> poll;
	
	public ArrayList<Boolean> getAnswered() {
		return answered.get(index_user);
	}

	public void setAnswered(int index,int poll_index,boolean value) {
		this.answered.get(index).set(poll_index, value); 
	}
	
	public void setIndexUser(int index) {
		this.index_user = index;
	}
	
	public int getIndexUser() {
		return index_user;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public ArrayList<Poll> get_Poll(){
		return poll;
	}

	public Model () {
		user_password = new ArrayList<ArrayList<String>>();
		user_password.add(new ArrayList<String>());
		user_password.add(new ArrayList<String>());
		poll = new ArrayList<Poll>();
		answered = new ArrayList<ArrayList<Boolean>>();
		add_user("Robin","toto");
		
		
		
		
		
	}
	
    public int check_user(String user,String password) {
    	int index = user_password.get(0).indexOf(user);
    	if (index == -1) {
    		return -1;
    	}
    	if(user_password.get(1).get(index).equals(password)) {
    		this.user = user;
    		return index;
    	}
    	
        return -1;
    }
    
    public boolean add_user (String user, String password) {
    	if (user.isBlank() || password.isBlank()) {
    		return false;
    	}
    	user_password.get(0).add(user);
		user_password.get(1).add(password);
		answered.add(new ArrayList<Boolean>());
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question1.txt"));
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question2.txt"));
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question3.txt"));
		poll.add(this.get_info("C:\\Users\\Robin\\Desktop\\Cours 2A\\Workspace\\Itue_project\\src\\application\\Poll_Question4.txt"));
		answered.get(user_password.get(0).indexOf(user)).add(false);
		answered.get(user_password.get(0).indexOf(user)).add(false);
		answered.get(user_password.get(0).indexOf(user)).add(false);
		answered.get(user_password.get(0).indexOf(user)).add(false);
		
		return true;
    }
    
    private Poll get_info(String path) {
  
         ArrayList<String> lines = new ArrayList<String>();
         File file = new File(path);
         try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
             String line;
             while ((line = reader.readLine()) != null) {
                lines.add(line);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
    	return (new Poll(lines));
    }
}
