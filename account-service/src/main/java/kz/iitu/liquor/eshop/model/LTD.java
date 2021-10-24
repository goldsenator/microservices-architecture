package kz.iitu.liquor.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "LTD")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LTD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_contact_person")
    private String companyContactPerson;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "company_contact_number")
    private String companyContactNumber;

    @Column(name = "company_website")
    private String companyWebsite;

    @Column(name = "company_profile")
    private String companyProfile;

    @Column(name = "vendor_username")
    private String vendorUsername;

    @Column(name = "vendor_password")
    private String vendorPassword;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
