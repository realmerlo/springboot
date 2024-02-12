package com.example.middleware2.interceptors;

import com.example.middleware2.entities.Month;
import com.example.middleware2.fakeDB.FakeDB;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;

public class MonthInterceptor implements HandlerInterceptor {
    @Autowired
    private FakeDB fakeDB;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberHeader = request.getHeader("monthNumber");

        if (monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }

        int monthNumber = Integer.parseInt(monthNumberHeader);
        Month selectedMonth = findMonth(monthNumber, fakeDB.lista);

        if (selectedMonth == null) {
            selectedMonth = new Month(0, "nope", "nope", "nope");
        }

        request.setAttribute("month", selectedMonth);

        return true;
    }

    private Month findMonth(int monthNumber, ArrayList<Month> monthList) {
        for (Month x : monthList) {
            if (x.getMonthNumber() == monthNumber) {
                return x;
            }
        }
        return null;
    }
}
