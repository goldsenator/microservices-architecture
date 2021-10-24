package kz.iitu.liquor.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Table(name = "customer")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator = "customergenerator")
    @SequenceGenerator(name = "customername", sequenceName = "customer_seq", allocationSize = 1)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "customer_name")
    private String customerName;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "password")
    private String password;
}
