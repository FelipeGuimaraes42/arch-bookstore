package com.felipeguimaraes42.archbookstore.mvc.controller.repositories;

import com.felipeguimaraes42.archbookstore.mvc.controller.entities.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
  @Query(value = "SELECT * FROM book b WHERE UPPER(b.title) LIKE %?1%", nativeQuery = true)
  List<BookEntity> findByTitle(final String query);
}
