package bean;

public class Contact_us {
    private String username;
    private String email;
    private String phone;
    private String proposal;

    public Contact_us() {
    }

    public Contact_us(String username, String email, String phone, String proposal) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.proposal = proposal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    @Override
    public String toString() {
        return "Contact_us{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", proposal='" + proposal + '\'' +
                '}';
    }
}
