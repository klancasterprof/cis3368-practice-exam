package edu.uh.tech.cis3368.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class ExamService {

    private ServerRepository serverRepository;

    @Autowired
    public ExamService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }
    /**
     * Problem 1
     * Create 5 servers and store them in the database. See handout for required data.
     */
    public void createData() {
    }


    public BigDecimal calculateSumByLocation(String location){
        return new BigDecimal("0.00"); // placeholder
    }




    public List<String> roomsContainingDnsServers() {
        return null;
    }
}
