package com.yildizmurat.Service;

import com.yildizmurat.Entity.ManagerInformation;
import com.yildizmurat.dto.ManagerInformationDto;

public interface ManagerInformationService {
    ManagerInformationDto save(ManagerInformationDto managerInformation);
    ManagerInformationDto getById(Long id);
    Boolean delete(ManagerInformationDto managerInformation);
}
