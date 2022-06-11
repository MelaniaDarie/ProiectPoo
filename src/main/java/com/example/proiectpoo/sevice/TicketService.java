package com.example.proiectpoo.sevice;

import com.example.proiectpoo.Ticket;
import com.example.proiectpoo.dao.TicketDao;
import jakarta.persistence.Persistence;


import java.util.List;


public class TicketService {
    private TicketDao ticketDao;

    public TicketService() {
        try {
            ticketDao = new TicketDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addClient(Ticket newClient) {
        ticketDao.create(newClient);
    }

    public void updateClient(Ticket updatedClient) {
        ticketDao.update(updatedClient);
    }

    public List<Ticket> getAllClients() {
        return ticketDao.findAll();
    }

    public Ticket findClient(Integer id) throws Exception {
        List<Ticket> clients = ticketDao.find(id);
        if (clients.size() == 0) {
            throw new Exception("Id not found!");
        }
        Ticket c = clients.get(0);
        return c;
    }
}
