package com.dourki.patientsmvc.sec.service;

import com.dourki.patientsmvc.sec.entities.AppRole;
import com.dourki.patientsmvc.sec.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
}
