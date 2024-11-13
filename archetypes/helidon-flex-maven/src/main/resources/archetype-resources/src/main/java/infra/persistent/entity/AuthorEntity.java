#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.entity;

import ${package}.core.model.base.Gender;
import ${package}.infra.persistent.entity.base.BaseEntity;
import com.mybatisflex.annotation.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Valid
@Data
@Table("author")
@EqualsAndHashCode(callSuper=true)
public class AuthorEntity extends BaseEntity {

    private Gender gender;

    @NotBlank

    @Size(min = 2, max = 50, message = "The field must be at least {min} and at most {max} characters")
    private String name;

    @Email
    private String email;

}
