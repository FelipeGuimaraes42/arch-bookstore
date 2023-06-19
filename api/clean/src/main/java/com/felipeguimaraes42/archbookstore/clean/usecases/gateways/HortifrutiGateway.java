package com.felipeguimaraes42.archbookstore.clean.usecases.gateways;

import com.felipeguimaraes42.archbookstore.clean.adapters.mappers.HortifrutiDataMapper;
import java.util.List;

public interface HortifrutiGateway {
  List<HortifrutiDataMapper> findAll();
}
