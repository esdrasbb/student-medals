package org.abpc.repository;

import org.abpc.bean.Student;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
