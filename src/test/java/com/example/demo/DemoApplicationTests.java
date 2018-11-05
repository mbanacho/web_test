package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.service.SimpleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Before
    public void setup() {
        Role role1 = new Role() {
            {
                setName("John");
                setLevel("1");
            }
        };
        Mockito.when(new Role()).thenReturn(role1);
    }

    @Mock
    SimpleService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(SimpleService.class);
    }

	@Test
	public void contextLoads() {
        Assert.assertEquals(HttpServletResponse.SC_OK,service.getIndexPage());
	}
}