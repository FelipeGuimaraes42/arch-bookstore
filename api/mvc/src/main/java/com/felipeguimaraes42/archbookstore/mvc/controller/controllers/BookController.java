package com.felipeguimaraes42.archbookstore.mvc.controller.controllers;

import static java.util.Objects.nonNull;

import com.felipeguimaraes42.archbookstore.mvc.controller.dtos.BookDTO;
import com.felipeguimaraes42.archbookstore.mvc.controller.services.GetBookService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookController {
  private final GetBookService getBookService;

  public BookController(final GetBookService getBookService) {
    this.getBookService = getBookService;
  }

  @GetMapping("/")
  public ModelAndView getAllBooks(final HttpSession httpSession) {
    List<BookDTO> books = getBookService.getAll();
    ModelAndView modelAndView = new ModelAndView("view/home");
    modelAndView.addObject("books", books);
    modelAndView.addObject("logged", false);
    if (nonNull(httpSession.getAttribute("username"))) {
      modelAndView.addObject("logged", true);
    }
    return modelAndView;
  }
}
