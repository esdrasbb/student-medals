package org.abpc.repository;

import org.abpc.bean.Medal;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface MedalRepository extends CrudRepository<Medal, Integer> {
}
