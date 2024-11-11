#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ${package}.halo.core.model.base.BaseModel;
import ${package}.halo.core.model.base.Gender;

import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
public class Author extends BaseModel {
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank
    @Size.List({
            @Size(min = 2, message = "The field must be at least {min} characters"),
            @Size(max = 50, message = "The field must be less than {max} characters")
    })
    private String name;

    @Email
    private String email;

    // mappedBy is the field of Book field
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> books;
}
