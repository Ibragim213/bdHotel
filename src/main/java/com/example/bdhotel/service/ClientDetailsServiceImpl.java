package com.example.bdhotel.service;


import com.example.bdhotel.dal.DataAccessLayer;
import com.example.bdhotel.models.Passenger;
import com.example.bdhotel.security.PassengersDetalesImpl;
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
        Passenger passenger = dataAccessLayer.getPassengerFromDatabaseByUsername(mail);
        if (passenger == null) return null;
        return PassengersDetalesImpl.build(passenger);
    }
}