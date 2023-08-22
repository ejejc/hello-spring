package hello.hellospring.ddd.domain;

import hello.hellospring.ddd.converter.MoneyConverter;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
public class Order {

    @EmbeddedId
    private OrderNo number;

    @Column(name = "total_amounts")
    // @Convert(converter = MoneyConverter.class) // autoApply == false일 경우
    private Money totalAmounts; // MoneyConverter를 통해서 값 변환된다.

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_line",
        joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "link_idx")
    private List<OrderLine> orderLines;
}

