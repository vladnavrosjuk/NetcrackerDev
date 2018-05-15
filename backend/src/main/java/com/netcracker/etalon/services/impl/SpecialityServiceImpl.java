/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties. 
 
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 
 All Rights Reserved.
 
*/
/*
 * Copyright 1995-2017 by NetCracker Technology Corp.,
 * University Office Park III
 * 95 Sawyer Road
 * Waltham, MA 02453
 * United States of America
 * All rights reserved.
 */
package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.FacultetEntity;
import com.netcracker.etalon.entities.SpecialityEntity;
import com.netcracker.etalon.repository.SpecialityRepository;
import com.netcracker.etalon.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;


    @Override
    public List<SpecialityEntity> findall() {
        return (List<SpecialityEntity>) specialityRepository.findAll();
    }

    @Override
    public void addspeciality(SpecialityEntity specialityEntity) {
        specialityRepository.save(specialityEntity);
    }

    @Override
    public SpecialityEntity findByName(String name) {
       return specialityRepository.findByName(name);
    }

    @Override
    public SpecialityEntity findById(Integer id) {
        return specialityRepository.findById(id);
    }

    @Override
    public List<SpecialityEntity> findByFacultetEntity(FacultetEntity facultetEntity) {
        return specialityRepository.findByFacultetEntity(facultetEntity);
    }
}
