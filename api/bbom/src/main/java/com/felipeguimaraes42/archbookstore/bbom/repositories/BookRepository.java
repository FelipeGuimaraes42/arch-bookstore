package com.felipeguimaraes42.archbookstore.bbom.repositories;

import com.felipeguimaraes42.archbookstore.bbom.domains.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  @Query(value = "SELECT * FROM book hf WHERE UPPER(hf.title) LIKE %?1%", nativeQuery = true)
  List<Book> findByName(final String query);
}
