package org.heartfulness.user;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Integer> {
    User save(User user);

}
