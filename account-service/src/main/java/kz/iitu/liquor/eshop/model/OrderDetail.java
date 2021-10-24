package kz.iitu.liquor.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "order_detail")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private CartProduct product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "quantity_price")
    private int quantityPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private LTD LTD;
}
