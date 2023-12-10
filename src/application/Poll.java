package application;

import java.util.ArrayList;

public class Poll {
	private String question;
	private enum Type {BOOL,QCM};
	private Type type;
	private ArrayList<Double> values;
	private Boolean answered;
	private String[] choices;
	
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
		this.values = new ArrayList<Double>();
		if (this.type == Type.BOOL) {
			this.values.add(Double.valueOf(list.get(2)));
			this.values.add(Double.valueOf(list.get(3)));
		}else if (this.type == Type.QCM) {
			int nb_item = Integer.valueOf(list.get(2));
			this.choices = new String [nb_item];
			for(int i=0; i<this.choices.length;i++) {
				this.choices[i] = list.get(3+i);
				this.values.add(Double.valueOf(list.get(i+nb_item+3)));
			}
		}
		
		
	}
	public String[] get_choices() {
		return this.choices;
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
