package murach.business;

import java.io.Serializable;

public class User implements Serializable {

    private String patronname;
    private String emailaddress;
    private String booktitle;
    private String duedate;
    private String overdue;

    public User() {
        email = "";
        firstName = "";
        lastName = "";
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}