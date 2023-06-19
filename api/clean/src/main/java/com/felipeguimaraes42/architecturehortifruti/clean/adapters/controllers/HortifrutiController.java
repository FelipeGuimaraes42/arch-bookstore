package com.felipeguimaraes42.architecturehortifruti.clean.adapters.controllers;

import com.felipeguimaraes42.architecturehortifruti.clean.usecases.boundaries.HortifrutiBoundary;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.hortifruti.HortifrutiResponseModel;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("hortifruti")
public class HortifrutiController {
  private final HortifrutiBoundary hortifrutiBoundary;

  public HortifrutiController(final HortifrutiBoundary hortifrutiBoundary) {
    this.hortifrutiBoundary = hortifrutiBoundary;
  }

  @GetMapping("/")
  public ResponseEntity<List<HortifrutiResponseModel>> getAll() {
    return new ResponseEntity<>(hortifrutiBoundary.getAll(), HttpStatus.OK);
  }
}
