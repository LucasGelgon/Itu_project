package application;

/**
 * Class representing user
 */
public class User {

    private String name;
    private String surname = "";
    private int age ;
    private String email = "";
    private boolean[] badges = {false,false,false};
    
    
    public User(String name) {
    	this.name = name;
    	
    }
    /**
     * Creates a user
     */
    public User(String theName, String theSurname , int theAge , String theEmail) {
        this.name = theName;
        this.surname = theSurname;
        this.age = theAge;
        this.email =theEmail;
    }

    /**
     * Returns the name of the user
     *
     * @return name of the user
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the surname of the user
     *
     * @return surname of the user
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Returns the age of the user
     *
     * @return age of the user
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Returns the email of the user
     *
     * @return email of the user
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the list of badges
     *
     * @return list of badges
     */
    public boolean[] getBadges() {
        return this.badges;
    }

    /**
     * Sets the name of the user
     *
     * @param name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the surname of the user
     *
     * @param surname of the user
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Sets the age of the user
     *
     * @param age of the user
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the email of the user
     *
     * @param email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the badges of the user
     *
     * @param badges of the user
     */
    public void setBadges(boolean[] badges) {
        this.badges = badges;
    }

}
