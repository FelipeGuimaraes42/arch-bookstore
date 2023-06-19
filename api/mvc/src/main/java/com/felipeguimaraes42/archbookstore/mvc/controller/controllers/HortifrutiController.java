package com.felipeguimaraes42.archbookstore.mvc.controller.controllers;

import static java.util.Objects.nonNull;

import com.felipeguimaraes42.archbookstore.mvc.controller.dtos.HortifrutiDTO;
import com.felipeguimaraes42.archbookstore.mvc.controller.services.GetHortifrutiService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HortifrutiController {
  private final GetHortifrutiService getHortifrutiService;

  public HortifrutiController(final GetHortifrutiService getHortifrutiService) {
    this.getHortifrutiService = getHortifrutiService;
  }

  @GetMapping("/")
  public ModelAndView getAllHortifruti(final HttpSession httpSession) {
    List<HortifrutiDTO> hortifrutiList = getHortifrutiService.getAll();
    ModelAndView modelAndView = new ModelAndView("view/home");
    modelAndView.addObject("hortifrutiList", hortifrutiList);
    modelAndView.addObject("logged", false);
    if (nonNull(httpSession.getAttribute("username"))) {
      modelAndView.addObject("logged", true);
    }
    return modelAndView;
  }
}
