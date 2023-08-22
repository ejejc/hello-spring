package hello.hellospring.ddd.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    private String address;

    public String getAddress() {
        return address;
    }

    public Email(String address) {
        this.address = address;
    }
}
