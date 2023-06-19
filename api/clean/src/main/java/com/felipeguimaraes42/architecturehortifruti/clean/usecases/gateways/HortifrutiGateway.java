package com.felipeguimaraes42.architecturehortifruti.clean.usecases.gateways;

import com.felipeguimaraes42.architecturehortifruti.clean.adapters.mappers.HortifrutiDataMapper;
import java.util.List;

public interface HortifrutiGateway {
  List<HortifrutiDataMapper> findAll();
}
