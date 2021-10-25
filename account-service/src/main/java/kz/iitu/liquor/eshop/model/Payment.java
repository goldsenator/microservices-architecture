package kz.iitu.liquor.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "payment")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference")
    private int reference;

    @Column(name = "payment_for")
    private String paymentFor;

    @Column(name = "amount_paid")
    private String amountPaid;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "paid_by")
    private String paidBy;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
