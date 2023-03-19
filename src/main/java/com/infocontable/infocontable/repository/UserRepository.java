package com.infocontable.infocontable.repository;

import com.infocontable.infocontable.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("Select u FROM User u WHERE u.nit = :nit")
    Optional<User> buscarPorNit(@Param("nit") String nit);
}
