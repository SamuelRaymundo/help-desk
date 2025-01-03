package org.samuelraymundo.helpdesk.domain.enums;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class User {

    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Set<Integer> profiles = new HashSet<>();
    private LocalDate creationDate = LocalDate.now();

    public User() {
        addProfiles(Profile.CLIENT);
    }

    public User(Integer id, String name, String cpf, String email, String password, Set<Integer> profiles, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.profiles = profiles;
        this.creationDate = creationDate;
        addProfiles(Profile.CLIENT);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().
                map(x -> Profile.toEnum(x)).
                collect(Collectors.toSet());
    }

    public void addProfiles(Profile profiles) {
        this.profiles.add(profiles.getCode());
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(cpf, user.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
