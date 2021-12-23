package com.switchfully.goatpark.domain.person.emailaddress;

import javax.persistence.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "EMAIL_ADDRESS")
public class EmailAddress {

    @Id
    @GeneratedValue(generator = "email_address_seq")
    private int id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "DOMAIN")
    private String domain;

    private static final String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public EmailAddress(String username, String domain) {
        if(!isValidEmail(username + "@" + domain)) {
            throw new IllegalArgumentException("This email address is not valid!");
        }
        this.username = username;
        this.domain = domain;
    }

    protected EmailAddress() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return username + "@" + domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress that = (EmailAddress) o;
        return Objects.equals(username, that.username) && Objects.equals(domain, that.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, domain);
    }
}
