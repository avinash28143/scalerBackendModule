package dev.avinash.productservice.inheritancedemo.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_tr")
public interface TaRepository extends JpaRepository<TA, Long> {

    @Override
    <S extends TA> S save(S entity);
}
