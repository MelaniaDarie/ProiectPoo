package com.example.proiectpoo;

import com.example.proiectpoo.enumeration.TimeTicket;
import com.example.proiectpoo.sevice.TicketService;
import com.example.proiectpoo.sevice.UserlogService;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args){
       UserlogService userlogService = new UserlogService();
        Userlog userlog = null;
        try {
            userlog = userlogService.findClient("mela@gmail.com","1234");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("User not found!");
        }
        System.out.println(userlog);
        /*userlogService.addClient(new Userlog("vve@yahoo.com","345","0789898982"));
        try {
           userlog = userlogService.findClient("vve@yahoo.com", "345");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //userlogService.updateClient(new Userlog("vvv@yahoo.com","345","0789898989"));
       // Ticket newTicket = new Ticket("area1",2,TimeTicket.ONE,2);
       // System.out.println(newTicket);
      TicketService ticketService = new TicketService();
        Ticket ticket = null;
        try {
            ticket = ticketService.findClient(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ticketService.addClient();
        System.out.println(ticket);
        ticketService.addClient(new Ticket("area3",3,TimeTicket.ONE,userlog));

    }
}
