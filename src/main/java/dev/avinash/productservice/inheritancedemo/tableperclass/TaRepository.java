package dev.avinash.productservice.inheritancedemo.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_tr")
public interface TaRepository extends JpaRepository<TA, Long> {

    @Override
    <S extends TA> S save(S entity);
}
