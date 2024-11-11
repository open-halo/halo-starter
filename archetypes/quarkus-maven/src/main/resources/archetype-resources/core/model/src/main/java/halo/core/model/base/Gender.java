#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.model.base;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
