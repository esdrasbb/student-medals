package org.abpc.repository;

import org.abpc.bean.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
