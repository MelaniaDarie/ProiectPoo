package com.example.proiectpoo;

import com.example.proiectpoo.enumeration.TimeTicket;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ticket_id", nullable = false)
    private int ticketId;

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Basic
    @Column(name = "price", nullable = false)
    private Integer price = 3;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "hours", nullable = false, length = -1)
    private TimeTicket hours;

   // @Basic
    //@Column(name = "user_id", nullable = true)
   // private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Userlog userlog = new Userlog();


/* public Userlog getUserlogByUserId() {
        return userlogByUserId;
    }

    public void setUserlogByUserId(Userlog userlogByUserId) {
        this.userlogByUserId = userlogByUserId;
    }*/

    public Ticket() {

    }

    public Ticket(String name, Integer price, TimeTicket hours) {
        this.name = name;
        this.price = price;
        this.hours = hours;
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

    public void setPrice(int price) {
        this.price = price;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket that = (Ticket) o;

        if (ticketId != that.ticketId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (hours != null ? !hours.equals(that.hours) : that.hours != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = ticketId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{"+
                ", name='" + name + '\'' +
                ", price=" + price +
                ", hours=" + hours +
                '}';
    }

    public Userlog getUserlog() {
        return userlog;
    }

    public void setUserlog(Userlog userlog) {
        this.userlog = userlog;
    }

}
