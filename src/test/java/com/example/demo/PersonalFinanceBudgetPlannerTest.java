package com.example.demo;

import com.example.demo.servlet.SimpleHelloServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PersonalFinanceBudgetPlannerTest {

    @Test
    void testDoGet() throws Exception {
        SimpleHelloServlet servlet = new SimpleHelloServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        servlet.doGet(request, response);

        verify(response).getWriter();
    }
}
