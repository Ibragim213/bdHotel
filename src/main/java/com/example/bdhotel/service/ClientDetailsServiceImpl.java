package com.example.bdhotel.service;


import com.example.bdhotel.dal.DataAccessLayer;
import com.example.bdhotel.models.Client;
import com.example.bdhotel.security.ClientsDetalesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class ClientDetailsServiceImpl implements UserDetailsService {
    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public ClientDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }


    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Client client = dataAccessLayer.getClientFromDatabaseByUsername(mail);
        if (client == null) return null;
        return ClientsDetalesImpl.build(client);
    }
}