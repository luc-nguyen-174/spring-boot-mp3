package com.example.mp3.repo.user;
import com.example.mp3.model.user.AppUser;
import com.example.mp3.model.DTO.ICountRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String name);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Query(nativeQuery = true, value = "select r.name, count(users.username) as 'number' from users join user_roles ur on users.id = ur.user_id join role r on r.id = ur.role_id group by r.name;")
    Iterable<ICountRole> getRoleNumber();
}
