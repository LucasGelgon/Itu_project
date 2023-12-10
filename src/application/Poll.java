package application;

import java.util.ArrayList;

public class Poll {
	private String question;
	private enum Type {BOOL,QCM};
	private Type type;
	private ArrayList<Double> values;
	private ArrayList<Double> raw_data;
	
	private String[] choices;
	
	public Poll(String question, Type type,ArrayList<Double> values) {
		this.question = question;
		this.type = type;
		this.values = new ArrayList<Double>(values);
	}
	
	public Poll(ArrayList<String> list) {
		this.question = list.get(0);
		this.type = Type.valueOf(list.get(1));
		this.values = new ArrayList<Double>();
		this.raw_data = new ArrayList<Double>();
		if (this.type == Type.BOOL) {
			this.raw_data.add(Double.valueOf(list.get(2)));
			this.raw_data.add(Double.valueOf(list.get(3)));
			this.raw_data.add(Double.valueOf(list.get(4)));
			this.values.add(Double.valueOf(raw_data.get(1)/raw_data.get(0)));
			this.values.add(Double.valueOf(raw_data.get(2)/raw_data.get(0)));

		}else if (this.type == Type.QCM) {
			int nb_item = Integer.valueOf(list.get(3));
			this.raw_data.add(Double.valueOf(list.get(2)));
			this.choices = new String [nb_item];
			for(int i=0; i<this.choices.length;i++) {
				this.choices[i] = list.get(4+i);
				this.raw_data.add(Double.valueOf(list.get(i+nb_item+4)));
				this.values.add(Double.valueOf(raw_data.get(i+1)/raw_data.get(0)));
			}
		}
		
		
	}
	public String[] get_choices() {
		return this.choices;
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
	
	public void affiche() {
		System.out.println(this.question);
		System.out.println(this.type);
		System.out.println(this.values);
	}
	
	
	public void set_raw_data (int index) {
		this.raw_data.set(0, this.raw_data.get(0)+1);
		this.raw_data.set(index, this.raw_data.get(index)+1);
		this.refresh_values();
	}
	
	public void refresh_values() {
		if (this.type == Type.BOOL) {
			this.values.set(0,Double.valueOf(raw_data.get(1)/raw_data.get(0)));
			this.values.add(1,Double.valueOf(raw_data.get(2)/raw_data.get(0)));

		}else if (this.type == Type.QCM) {
			for(int i=0; i<this.choices.length;i++) {
				this.values.set(i,Double.valueOf(raw_data.get(i+1)/raw_data.get(0)));
			}
		}
	}
}
