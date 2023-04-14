package com.example.mp3.service.approle;


import com.example.mp3.model.user.AppRole;
import com.example.mp3.service.IGeneralService;

import java.util.Set;

public interface IAppRoleService extends IGeneralService<AppRole> {
    AppRole findByName(String name);
    Set<AppRole> getRolesByName(Set<String> roleNames);
}
