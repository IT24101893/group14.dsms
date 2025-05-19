package com.group14.dsms.library.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        model.addAttribute("status", status);
        model.addAttribute("message", message);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == 404) {
                return "error-404";
            } else if (statusCode == 500) {
                return "error-500";
            }
        }
        return "error";
    }
}