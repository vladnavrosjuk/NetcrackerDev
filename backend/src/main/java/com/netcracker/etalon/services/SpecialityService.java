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
package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.FacultetEntity;
import com.netcracker.etalon.entities.SpecialityEntity;

import java.util.List;


public interface SpecialityService {

    List<SpecialityEntity> findall();
    void addspeciality(SpecialityEntity specialityEntity);
    SpecialityEntity findByName(String name);
    SpecialityEntity findById(Integer id);
    List<SpecialityEntity> findByFacultetEntity(FacultetEntity facultetEntity);
}
