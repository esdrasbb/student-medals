package org.abpc.repository;

import org.abpc.bean.Medal;
import org.abpc.bean.to.StudentMedalTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface MedalRepository extends CrudRepository<Medal, Integer> {

    String GET_MEDAL_AMOUNT = "SELECT new org.abpc.bean.to.StudentMedalTO(m.student, sum(m.amount)) FROM Medal m GROUP BY m.student ORDER BY sum(m.amount) DESC";

    @Query(value = GET_MEDAL_AMOUNT)
    Iterable<StudentMedalTO> getMedalAmount();

    Medal getByStudentIdAndClassesId(@Param("studentId") Integer studentId, @Param("classesId") Integer classesId);

}
