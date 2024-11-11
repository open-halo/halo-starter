#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ${package}.halo.core.model.base.BaseModel;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Book extends BaseModel {

    @NotBlank
    private String name;

    @NotNull
    @Min(value = 1)
    private Integer edition;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "99999.9")
    @Digits(integer = 8, fraction = 2)
    private BigDecimal price;

//    @NotNull
//    private Long authorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", nullable = false)
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_store_link",
            joinColumns = @JoinColumn(name = "bookId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "storeId", referencedColumnName = "id"))
    private Set<Store> stores;
}
