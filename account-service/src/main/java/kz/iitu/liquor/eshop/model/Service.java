package kz.iitu.liquor.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "vendor")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long service_id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "reference_no")
    private String referenceNo;

    @Column(name = "service_detail")
    private String serviceDetail;

    @Column(name = "service_fee")
    private String serviceFee;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private LTD LTD;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
