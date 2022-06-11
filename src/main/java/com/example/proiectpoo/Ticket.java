package com.example.proiectpoo;

import com.example.proiectpoo.enumeration.TimeTicket;
import jakarta.persistence.*;

@Entity
@Table(name = "ticket", schema = "public", catalog = "JavaFx")
public class Ticket {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ticket_id")
    private int ticketId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "price")
    private Integer price;

    @Enumerated(EnumType.STRING)
    private TimeTicket hours;

    @Basic
    @Column(name = "user_id")
    private Integer userId;

   @ManyToOne
   @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Userlog userlog;

    public Ticket() {

    }

    public Ticket(String name, Integer price, TimeTicket hours, Integer userId) {
        this.name = name;
        this.price = price;
        this.hours = hours;
        this.userId= userId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public TimeTicket getHours() {
        return hours;
    }

    public void setHours(TimeTicket hours) {
        this.hours = hours;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket that = (Ticket) o;

        if (ticketId != that.ticketId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (hours != null ? !hours.equals(that.hours) : that.hours != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ticketId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{"+
                ", name='" + name + '\'' +
                ", price=" + price +
                ", hours=" + hours +
                ", userId="+userId+
                '}';
    }

    public Userlog getUserlog() {
        return userlog;
    }

    public void setUserlog(Userlog userlog) {
        this.userlog = userlog;
    }

    /* public Userlog getUserlogByUserId() {
        return userlogByUserId;
    }

    public void setUserlogByUserId(Userlog userlogByUserId) {
        this.userlogByUserId = userlogByUserId;
    }*/
}
