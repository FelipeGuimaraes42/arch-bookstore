package com.felipeguimaraes42.archbookstore.clean.adapters.repositories.book;

import com.felipeguimaraes42.archbookstore.clean.adapters.mappers.BookDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBookRepository extends JpaRepository<BookDataMapper, Long> {}
