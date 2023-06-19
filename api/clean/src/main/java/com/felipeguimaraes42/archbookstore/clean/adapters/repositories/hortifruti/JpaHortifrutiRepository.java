package com.felipeguimaraes42.archbookstore.clean.adapters.repositories.hortifruti;

import com.felipeguimaraes42.archbookstore.clean.adapters.mappers.HortifrutiDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHortifrutiRepository extends JpaRepository<HortifrutiDataMapper, Long> {}