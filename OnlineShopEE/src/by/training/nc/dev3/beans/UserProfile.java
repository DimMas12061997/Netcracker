package by.training.nc.dev3.beans;


public class UserProfile extends Entity {
    private int idProfile;
    private String email;
    private String address;
    private double budget;
    private String creditCard;
    private int userId;

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "idProfile=" + idProfile +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", budget=" + budget +
                ", creditCard='" + creditCard + '\'' +
                ", userId=" + userId +
                '}';
    }
}
