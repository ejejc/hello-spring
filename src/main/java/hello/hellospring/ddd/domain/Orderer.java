package hello.hellospring.ddd.domain;

import jakarta.persistence.*;

@Embeddable
public class Orderer {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "order_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;
}
