package edu.uh.tech.cis3368.exam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ServerRepository extends CrudRepository<Server,Integer> {

    @Query(value = "select count(*) from server",nativeQuery = true)
    public int getServerCount();

    public ArrayList<Server> findServersByLocation(String location);

    public ArrayList<Server> findServersByNameContaining(String partialName);
}
