package hello.hellospring.ddd.domain;


import jakarta.persistence.Embeddable;

@Embeddable
public class Money {
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public Money(Integer value) {
        this.value = value;
    }
}
