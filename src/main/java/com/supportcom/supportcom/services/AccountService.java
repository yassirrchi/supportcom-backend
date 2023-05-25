package com.supportcom.supportcom.services;

import com.supportcom.supportcom.entities.CustomUser;
import com.supportcom.supportcom.entities.CustomRole;

import java.util.List;

public interface AccountService {
    CustomUser addNewUser(CustomUser cuser);
    CustomRole addNewRole(CustomRole role);
    void addRoleToUser(String username,String rolename);
    CustomUser loadUserByUsername(String username);
    List<CustomUser> listUsers();
}
