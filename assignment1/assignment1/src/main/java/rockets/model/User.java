package rockets.model;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;

public class User extends Entity {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    /**
     * email shouldn't be null.
     *
     * @param email
     */
    public User(String email) {
        notNull(email);

        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        if (null == password) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.trim().equals("")) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        // check if the string is a strong password. At least 8 length. Contains at least 1 special character, 1 lower&upper letter, and 1 number
        if(!password.trim().matches("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8}$")){
            throw new IllegalArgumentException("Password not strong enough.");
        }

        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
