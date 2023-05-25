package com.supportcom.supportcom.services;

import com.supportcom.supportcom.entities.CustomUser;
import com.supportcom.supportcom.entities.CustomRole;
import com.supportcom.supportcom.repositories.CustomeUserRepository;
import com.supportcom.supportcom.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor



public class AccountServiceImpl implements AccountService {

    private CustomeUserRepository customeUserRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public CustomUser addNewUser(CustomUser cuser) {
        String pw=cuser.getPassword();
        cuser.setPassword(passwordEncoder.encode(pw));

        return customeUserRepository.save(cuser);
    }

    @Override
    public CustomRole addNewRole(CustomRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        CustomUser cuser=customeUserRepository.findByUsername(username);
        CustomRole role=roleRepository.findByRolename(rolename);
        cuser.getRoles().add(role);

    }

    @Override
    public CustomUser loadUserByUsername(String username) {
        return customeUserRepository.findByUsername(username);
    }

    @Override
    public List<CustomUser> listUsers() {
        return customeUserRepository.findAll();
    }
}
