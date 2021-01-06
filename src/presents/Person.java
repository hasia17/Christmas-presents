package presents;

public class Person {

    private String name;
    private String email;
    private String rejectedEmail = null;

    public Person(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNotReceiverEmail(String notReceiverEmail) {
        this.rejectedEmail = notReceiverEmail;
    }

    public String getRejectedEmail() {
        return rejectedEmail;
    }

}
