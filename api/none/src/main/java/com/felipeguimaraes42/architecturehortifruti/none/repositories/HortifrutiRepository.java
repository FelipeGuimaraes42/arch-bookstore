package com.felipeguimaraes42.architecturehortifruti.none.repositories;

import com.felipeguimaraes42.architecturehortifruti.none.domains.Hortifruti;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HortifrutiRepository extends JpaRepository<Hortifruti, Long> {
  @Query(value = "SELECT * FROM hortifruti hf WHERE UPPER(hf.name) LIKE %?1%", nativeQuery = true)
  List<Hortifruti> findByName(final String query);
}
