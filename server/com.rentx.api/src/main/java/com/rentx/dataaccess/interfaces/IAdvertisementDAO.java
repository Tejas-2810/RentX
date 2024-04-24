package com.rentx.dataaccess.interfaces;

import com.rentx.entities.Advertisement;

import java.util.List;


public interface IAdvertisementDAO {
    /**
     * method to find all in advertisement DAO
     * @return list of advertisement
     */
    List<Advertisement> findAll();
}
