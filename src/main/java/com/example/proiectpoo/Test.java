package com.example.proiectpoo;

import com.example.proiectpoo.enumeration.TimeTicket;
import com.example.proiectpoo.sevice.TicketService;
import com.example.proiectpoo.sevice.UserlogService;

public class Test {
    public static void main(String[] args){
       /* UserlogService userlogService = new UserlogService();
        Userlog userlog = null;
        try {
            userlog = userlogService.findClient("mela@gmail.com","1234");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("User not found!");
        }
        System.out.println(userlog);
        //userlogService.addClient(new Userlog("vvv@yahoo.com","345","0789898989"));
        try {
           userlog = userlogService.findClient("vvv@yahoo.com", "345");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Ticket newTicket = new Ticket();
        newTicket.setHours(TimeTicket.ONE);
        newTicket.setName("area1");
        newTicket.setPrice(2);
        newTicket.setUserId(2);
      TicketService ticketService = new TicketService();
      ticketService.addClient(newTicket);
    }
}
