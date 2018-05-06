package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.CoordinatEntity;
import com.netcracker.etalon.entities.RequestEntity;

public interface CoordinateService {
    void addCoordinate(CoordinatEntity coordinatEntity);
    CoordinatEntity findByRequest (RequestEntity requestEntity);

}
