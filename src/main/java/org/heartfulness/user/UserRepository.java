package org.heartfulness.user;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends Repository<User, Integer> {

    void save(User user);

    Set<User> findAllByEmail(String email);

    Set<User> findAllByWhatsappNumber(String whatsapp);

    Set<User> findAllBySmsNumber(String sms);

    List<User> findAllByEmailOrSmsNumberOrWhatsappNumber(String email, String sms, String wa);

    User findById(Integer id);

}
