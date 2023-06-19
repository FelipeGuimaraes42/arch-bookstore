package com.felipeguimaraes42.archbookstore.mvc.controller.repositories;

import com.felipeguimaraes42.archbookstore.mvc.controller.entities.HortifrutiEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HortifrutiRepository extends JpaRepository<HortifrutiEntity, Long> {
  @Query(value = "SELECT * FROM hortifruti hf WHERE UPPER(hf.name) LIKE %?1%", nativeQuery = true)
  List<HortifrutiEntity> findByName(final String query);
}
