package kz.iitu.liquor.eshop.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Table(name = "_customer")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "customer_gen"
    )
    @SequenceGenerator(
            name = "customer_gen",
            sequenceName = "_customer_seq",
            allocationSize = 1
    )
    @Column(name = "customer_id")
    private  id;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "customer_name")
    private String customerName;

    @Lob
    @Column(name = "avatar")
    private byte[] avatar;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "complete_address")
    private String completeAddress;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}