package com.supportcom.supportcom.controllers;

import com.supportcom.supportcom.entities.CustomRole;
import com.supportcom.supportcom.entities.CustomUser;
import com.supportcom.supportcom.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {
    private AccountService accountService;
    @GetMapping("/users")
    public List<CustomUser> allUsers(){
        return accountService.listUsers();
    }
    @PostMapping("/users")
    public CustomUser saveUser(@RequestBody CustomUser cuser){
        return accountService.addNewUser(cuser);
    }
    @PostMapping("/role")
    public CustomRole saveRole(@RequestBody CustomRole crole){
        return accountService.addNewRole(crole);
    }
    @PostMapping("/addroletouser")
    public void addRoletoUseer(@RequestBody RoleUserForm roleUserForm){
          accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRolename());
    }


}
@Data
class RoleUserForm{
    private String username;
    private String rolename;
}
