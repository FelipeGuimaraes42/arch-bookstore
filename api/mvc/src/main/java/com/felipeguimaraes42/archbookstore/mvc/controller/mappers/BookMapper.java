package com.felipeguimaraes42.archbookstore.mvc.controller.mappers;

import com.felipeguimaraes42.archbookstore.mvc.controller.dtos.BookDTO;
import com.felipeguimaraes42.archbookstore.mvc.controller.entities.BookEntity;
import com.felipeguimaraes42.archbookstore.mvc.model.Book;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
  BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

  BookDTO toBookDTO(final BookEntity bookEntity);

  List<BookDTO> toBookDTOs(final List<BookEntity> bookEntities);

  BookEntity toHortifrutiEntity(final Book book);
}
