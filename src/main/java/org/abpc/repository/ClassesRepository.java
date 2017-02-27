package org.abpc.repository;

import org.abpc.bean.Classes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ClassesRepository extends CrudRepository<Classes, Integer> {

    String FIND_WITHOUT_STUDENTS = "SELECT c FROM Classes c " +
            "WHERE c.id NOT IN (SELECT m.classes.id FROM Medal m WHERE m.student.id = :studentId)";

    String FIND_WITH_STUDENTS = "SELECT c FROM Classes c " +
            "WHERE c.id IN (SELECT m.classes.id FROM Medal m WHERE m.student.id = :studentId)";

    Iterable<Classes> findAllByOrderByDateAsc();

    @Query(FIND_WITHOUT_STUDENTS)
    Iterable<Classes> findClassesWithoutStudent(@Param("studentId") Integer studentId);

    @Query(FIND_WITH_STUDENTS)
    Iterable<Classes> findClassesWithStudent(@Param("studentId") Integer studentId);
}
