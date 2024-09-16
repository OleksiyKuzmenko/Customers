package com.example.demoRest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private UUID id;

    @NotBlank
    private String fullName;
    private String email;
    private String phone;

    @Column(nullable = true)
    private Boolean isActive = true;

    public Customer() {
    }

    public Customer(@JsonProperty("id") UUID id,
                    @JsonProperty("fullName") String fullName,
                    @JsonProperty("email") String email,
                    @JsonProperty("phone") String phone,
                    @JsonProperty("isActive") Boolean isActive) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
