package com.joinup.model;

import java.util.Objects;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String phone;
    private Role role = Role.USER;

    public User() {}

    public User(Long id, String firstName, String lastName, String company, String email, String phone, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.role = role == null ? Role.USER : role;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role == null ? Role.USER : role; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User that = (User) o;
        return Objects.equals(id, that.id);
    }

    @Override public int hashCode() { return Objects.hash(id); }

    public String getDisplayName() {
        String f = firstName != null ? firstName : "";
        String l = lastName  != null ? lastName  : "";
        String n = (f + " " + l).trim();
        return n.isEmpty() ? (email != null ? email : "User") : n;
    }
}
