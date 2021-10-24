package kz.iitu.liquor.eshop.categoty;

import kz.iitu.liquor.eshop.model.Cart;
import kz.iitu.liquor.eshop.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "cart_category")
@AllArgsConstructor
@NoArgsConstructor
public class CartCategory {

    @Id
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "category_name")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;


}
