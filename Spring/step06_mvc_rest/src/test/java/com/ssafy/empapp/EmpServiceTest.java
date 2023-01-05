package com.ssafy.empapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.empapp.model.dto.Emp;
import com.ssafy.empapp.model.service.EmpService;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", 
"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Transactional
@RunWith(SpringRunner.class)
public class EmpServiceTest {

    @Autowired
    EmpService empService;
    
    @Test
    public void registerEmp() {
        Emp e = new Emp(9997, "김싸피", "ENGINEER", 7839, "2022-10-28", 4000, 0, 10);
        assertEquals(true, empService.insertEmp(e));
    }
}