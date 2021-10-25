package kz.iitu.liquor.eshop.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Data
public class UserRoles {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_role_users_fk"))
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "user_role_roles_fk"))
    private Role role;

}
