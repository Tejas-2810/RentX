package com.rentx.dataaccess;

import com.rentx.dataaccess.interfaces.IAdvertisementDAO;
import com.rentx.entities.Advertisement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertisementDAO implements IAdvertisementDAO {
    /**
     * define methods for entity manager
     */
    private EntityManager entityManager;

    /**
     * set up for constructor injection
     */
    @Autowired
    public AdvertisementDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    /**
     * method to find All advertisement
     * @return advertisment object
     */
    @Override
    public List<Advertisement> findAll() {
        //create a query
        TypedQuery<Advertisement> query = entityManager.createQuery("from Advertisement", Advertisement.class);

        //execute the query and get result list
        List<Advertisement> advertisements = query.getResultList();

        //returns the result
        return advertisements;
    }
}
