package com.example.demo;

import com.example.demo.servlet.SimpleHelloServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class PersonalFinanceBudgetPlannerTest {

    @Test
    void testDoGet() throws Exception {
        SimpleHelloServlet servlet = new SimpleHelloServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        verify(response).getWriter();
        verify(writer).write(anyString());
    }
}
