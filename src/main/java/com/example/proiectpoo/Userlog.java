package com.example.proiectpoo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name="userlog")
public class Userlog implements Serializable {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id",nullable = false)
    private long userId;

    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;

    @Basic
    @Column(name = "phone", nullable = false, length = -1)
    private String phone;

    @OneToMany(mappedBy = "userlog",cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();
    //private List<Ticket> tickets = new ArrayList<>();
    /*@OneToMany(mappedBy = "userlog",orphanRemoval = true,cascade = CascadeType.ALL)
    private Collection<Ticket> tickets;
    private List<Ticket> comments = new ArrayList<>();*/

    public Userlog() {

        }

    public Userlog(String email, String password, String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userlog user = (Userlog) o;
        return email != null && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +"{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
