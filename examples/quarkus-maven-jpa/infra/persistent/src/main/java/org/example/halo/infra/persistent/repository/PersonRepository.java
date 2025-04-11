package org.example.halo.infra.persistent.repository;

//import io.quarkus.hibernate.orm.panache.PanacheRepository;
//import io.quarkus.panache.common.Parameters;
//import jakarta.enterprise.context.ApplicationScoped;
//import org.example.halo.infra.persistent.entity.Person;
//import org.example.halo.infra.persistent.entity.Status;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@ApplicationScoped
//public class PersonRepository implements PanacheRepository<Person> {
//    public Person findByName(String name) {
//        return find("name", name).firstResult();
//    }
//
//    public List<Person> findAlive() {
//        return list("status", Status.Alive);
//    }
//
//    public List<Person> findByBirth(LocalDate birth) {
//        return find("#Person.selectByBirth",
//                Parameters.with("birth", birth)).stream().toList();
//    }
//
//    public void deleteStefs() {
//        delete("name", "Stef");
//    }
//}
