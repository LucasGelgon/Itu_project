package application;

import java.util.ArrayList;

public class Poll {
	private String question;
	private enum Type {Bool,QCM};
	private Type type;
	private ArrayList<Double> values;
	private Boolean answered;
	
	public Poll(String question, Type type,ArrayList<Double> values) {
		
		this.answered = false;
		this.question = question;
		this.type = type;
		this.values = new ArrayList<Double>(values);
	}
	
	public Poll(ArrayList<String> list) {
		this.question = list.get(0);
		this.answered = false;
		this.type = Type.valueOf(list.get(1));
		if (this.type == Type.Bool) {
			this.values = new ArrayList<Double>();
			this.values.add(Double.valueOf(list.get(2)));
			this.values.add(Double.valueOf(list.get(3)));
		}else if (this.type == Type.QCM) {
			
		}
		
		
	}
	
	public void set_answered(boolean bool) {
		this.answered = bool;
	}
	
	public String getQuestion() {
		return question;
	}

	public Type getType() {
		return type;
	}

	public ArrayList<Double> getValues() {
		return values;
	}
	
	public boolean get_answered() {
		return this.answered;
	}
	
	public void affiche() {
		System.out.println(this.question);
		System.out.println(this.type);
		System.out.println(this.values);
	}
	
	
}
