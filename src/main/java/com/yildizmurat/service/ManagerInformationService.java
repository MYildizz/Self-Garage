package com.yildizmurat.service;

import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ManagerInformationDto;

public interface ManagerInformationService {

    ManagerInformationDto save(ManagerInformationDto managerInformation);
    ManagerInformationDto getById(Long id);
    Boolean delete(Long id);
    ManagerInformationDto update(Long id, ManagerInformationDto managerInformation);
    Boolean userExist(String userId);
    Boolean mailExist(String e_mail);
    Boolean checkPassword(String password);
}
