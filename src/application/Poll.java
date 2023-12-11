package application;

import java.util.ArrayList;
/**
 * Class representing a survey. The functions allow you to modify and consult a single survey
 * @author Robin
 *
 */
public class Poll {
	/**
	 * Stores the survey question
	 */
	private String question;
	/**
	 *Enumeration to define the Type of survey; QCM: several possible answers; BOOL: yes or no only
	 */
	private enum Type {BOOL,QCM};
	/**
	 * Type of survey
	 */
	private Type type;
	/**
	 * Stores the computed values (between 0,1) to be displayed
	 */
	private ArrayList<Double> values;
	/**
	 * Stores the raw values like how much answers for this one, how many people answered...
	 */
	private ArrayList<Double> raw_data;
	/**
	 * Table of choices for the QCM type. Stores the differents choices for the user. 
	 */
	private String[] choices;
	/**
	 * Constructor of a survey
	 * @param question Stores the survey question
	 * @param type Type of survey
	 * @param values  Stores the raw values 
	 */
	public Poll(String question, Type type,ArrayList<Double> raw_data) {
		this.question = question;
		this.type = type;
		this.raw_data = new ArrayList<Double>(raw_data);
		this.values = new ArrayList<Double>();
		this.refresh_values();
	}
	
	/**
	 * Constructor of a survey from a String List
	 * @param list List of String that contains the informations about a survey
	 */
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
	/**
	 * Print in the Terminal the survey (only for debugging)
	 */
	public void affiche() {
		System.out.println(this.question);
		System.out.println(this.type);
		System.out.println(this.values);
	}
	
	/**
	 * Update the raw data by adding +1 to a value and to the total of answers and refresh the computed values 
	 * @param index index of the value to be update in the raw_data table
	 */
	public void set_raw_data (int index) {
		this.raw_data.set(0, this.raw_data.get(0)+1);
		this.raw_data.set(index, this.raw_data.get(index)+1);
		this.refresh_values();
	}
	/**
	 * Compute the new values for the array values. 
	 */
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
