package nett.formacion.aaa.module4.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nett.formacion.aaa.module4.jpa.Atleta;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta,Long>{

}
