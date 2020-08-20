package com.iiht.ecoronakit.enums;


public enum Role {
    User("User"), Admin("Admin"),SuperAdmin("SuperAdmin");

    private String role;

    Role(String role){
        this.role = role;
    }
}
