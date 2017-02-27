package org.abpc.repository;

import org.abpc.bean.Student;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Collection<Student> findAllByOrderByNameAsc();
}
