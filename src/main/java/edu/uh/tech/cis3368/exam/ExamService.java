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
        var servers = Arrays.asList(
                new Server("Main","T2 110",new BigDecimal("3424.73")),
                new Server("Backup", "T2 110",new BigDecimal("2509.10")),
                new Server("DNS","T3 121", new BigDecimal("5020.35")),
                new Server("DNS2","T3 121", new BigDecimal("5499.27")),
                new Server("DNS3","T2 110",new BigDecimal("2909.13")));

        servers.forEach(serverRepository::save);
    }


    public BigDecimal calculateSumByLocation(String location){
        ArrayList<Server> servers = serverRepository.findServersByLocation(location);
        var sum = servers.stream()
                .map(x -> x.getReplacementCost())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum;
    }




    public List<String> roomsContainingDnsServers() {
        var servers = serverRepository.findServersByNameContaining("DNS");
        return servers
                .stream()
                .map(s -> s.getLocation())
                .distinct()
                .collect(Collectors.toList());
    }
}
