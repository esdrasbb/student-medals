package org.abpc.repository;

import org.abpc.bean.Classes;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ClassesRepository extends CrudRepository<Classes, Long> {
}
