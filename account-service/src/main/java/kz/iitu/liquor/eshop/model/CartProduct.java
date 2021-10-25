package kz.iitu.liquor.eshop.model;

import kz.iitu.liquor.eshop.categoty.CartCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "cart_product")
@AllArgsConstructor
@NoArgsConstructor
public class CartProduct {

    @Id
    @Column(name = "id_cart_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "detail")
    private String detail;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private CartCategory cartCategory;
}
