#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ${package}.halo.core.model.base.BaseModel;

import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
public class Store extends BaseModel {
    @NotBlank
    private String name;

    @NotBlank
    private String website;

    @ManyToMany(mappedBy = "stores", fetch = FetchType.LAZY)
    private Set<Book> books;
}
