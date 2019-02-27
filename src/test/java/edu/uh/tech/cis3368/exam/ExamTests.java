package edu.uh.tech.cis3368.exam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamTests {


	@Autowired
	ServerRepository serverRepository;

	@Autowired
	ExamService examService;


	@Test
	public void populateServerTable(){
		serverRepository.deleteAll();
		examService.createData();
		var servers = serverRepository.getServerCount();
		assertEquals(5,servers);

	}

	@Test
	public void sumUsingRepository(){
		serverRepository.deleteAll();
		examService.createData();
		var sum = examService.calculateSumByLocation("T3 121");
		assertTrue(sum.compareTo(new BigDecimal("10519.62")) == 0);
	}

	@Test
	public void roomsContainingDnsSevers(){
		var locations = examService.roomsContainingDnsServers();
		System.out.println(locations);
		assertEquals(locations.get(0),"T3 121");
		assertEquals(locations.get(1),"T2 110");

	}

}
