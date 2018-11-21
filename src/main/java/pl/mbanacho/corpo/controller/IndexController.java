package pl.mbanacho.corpo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mbanacho.corpo.database.model.Employee;
import pl.mbanacho.corpo.database.model.Order;
import pl.mbanacho.corpo.service.DashboardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class IndexController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/")
    String getIndex(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }

    @GetMapping(value = "/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if(logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        model.addAttribute("msg", "aaa");
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
        model.addAttribute("serverTime", dateFormat.format(new Date()));
        return "login";
    }

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }

    @GetMapping(value = "/index")
    public ModelAndView indexPage(){
        ModelAndView mav = new ModelAndView("index");
        try{
            List<Order> orders = dashboardService.getLastTwentySales();
            mav.addObject("orders",orders);
            mav.setStatus(HttpStatus.OK);
            return mav;
        }catch(Exception e){
            mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            mav.setViewName("error");
            return mav;
        }
    }
}