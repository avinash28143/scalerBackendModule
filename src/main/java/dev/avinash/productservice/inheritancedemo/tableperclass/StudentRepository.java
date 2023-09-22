package dev.avinash.productservice.inheritancedemo.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_sr")
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    <S extends Student> S save(S entity);
}
