package com.felipeguimaraes42.architecturehortifruti.none.controllers;

import com.felipeguimaraes42.architecturehortifruti.none.domains.Hortifruti;
import com.felipeguimaraes42.architecturehortifruti.none.domains.HortifrutiCart;
import com.felipeguimaraes42.architecturehortifruti.none.services.GetHortifrutiService;
import com.felipeguimaraes42.architecturehortifruti.none.services.HortifrutiCartService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hortifruti")
@CrossOrigin
public class HortifrutiController {
  private final GetHortifrutiService getHortifrutiService;
  private final HortifrutiCartService hortifrutiCartService;

  public HortifrutiController(
      final GetHortifrutiService getHortifrutiService,
      final HortifrutiCartService hortifrutiCartService) {
    this.getHortifrutiService = getHortifrutiService;
    this.hortifrutiCartService = hortifrutiCartService;
  }

  @GetMapping("/")
  public ResponseEntity<List<Hortifruti>> getAllHortifruti() {
    return new ResponseEntity<>(getHortifrutiService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/item")
  public ResponseEntity<Hortifruti> getOneHortifruti(@RequestParam final Long id) {
    return new ResponseEntity<>(getHortifrutiService.getOne(id), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Hortifruti>> getAllHortifruti(@RequestParam final String query) {
    return new ResponseEntity<>(getHortifrutiService.searchByName(query), HttpStatus.OK);
  }

  @PostMapping("/cart")
  public ResponseEntity<Double> getCartValue(
      @RequestBody final List<HortifrutiCart> hortifrutiCartList) {
    return new ResponseEntity<>(hortifrutiCartService.execute(hortifrutiCartList), HttpStatus.OK);
  }
}
