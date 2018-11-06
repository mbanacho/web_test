package com.example.demo;

import pl.mbanacho.cars.service.SimpleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Mock
    SimpleService serviceMock;

    @Spy
    SimpleService serviceSpy;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(SimpleService.class);
        Mockito.when(serviceMock.getIndexPage()).thenReturn(ResponseEntity.of(Optional.of("aaaaa")));
    }

	@Test
	public void contextLoads() {
        verify(serviceMock, times(1)).getIndexPage();
        SimpleService service = new SimpleService();
        Assert.assertEquals(HttpServletResponse.SC_OK,service.getIndexPage());
	}
}