package com.example.proiectpoo.sevice;

import com.example.proiectpoo.Userlog;
import com.example.proiectpoo.dao.UserlogDao;
import com.example.proiectpoo.exceptions.EmailNotFoundException;
import com.example.proiectpoo.exceptions.PassNotFoundException;
import jakarta.persistence.Persistence;

import java.util.List;

public class UserlogService {
    private UserlogDao userDao;

    public UserlogService() {
        try {
            userDao = new UserlogDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addClient(Userlog newClient) {
        userDao.create(newClient);
    }

    public void updateClient(Userlog updatedClient) {
        userDao.update(updatedClient);
    }

    public List<Userlog> getAllClients() {
        return userDao.findAll();
    }

    /// for login
    public Userlog findClient(String email, String password) throws Exception {
        List<Userlog> clients = userDao.find(email);
        if (clients.size() == 0) {
            throw new EmailNotFoundException();
        }
        Userlog client = clients.get(0);

        if (password.compareTo(client.getPassword()) != 0) {
            throw new PassNotFoundException();
        }
        return client;
    }
}
