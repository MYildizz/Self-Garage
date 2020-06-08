package com.yildizmurat.Service;

import com.yildizmurat.Entity.ManagerInformation;

public interface ManagerInformationService {
    ManagerInformation save(ManagerInformation managerInformation);
    ManagerInformation getById(Long id);
    Boolean delete(ManagerInformation managerInformation);
}
