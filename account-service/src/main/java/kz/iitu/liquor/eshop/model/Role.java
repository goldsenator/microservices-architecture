package kz.iitu.liquor.eshop.model;

import kz.iitu.liquor.eshop.enums.Roles;
import kz.iitu.liquor.eshop.utility.EnumDB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Data
@Entity
@Table(name = "_roles")
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs({
        @TypeDef(name = "enum_postgre", typeClass = EnumDB.class)
})
public class Role {

    @Id
    @Column(name = "role_id")
    Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    @Type(type = "enum_postgre")
    private Roles roleName;

    @Column(name = "description")
    private String description;
}
