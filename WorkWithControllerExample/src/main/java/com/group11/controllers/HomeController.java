package com.group11.controllers;

import com.group11.db.DBManager;
import com.group11.db.Users;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping(value = {"/index"})
    public ModelAndView indexPage(){

        ModelAndView mw = new ModelAndView("index");
        return mw;

    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView page(@RequestParam(name = "count", required = false, defaultValue = "1") int amount){

        for(int i=0;i<amount;i++){
            System.out.println(i+" -> "+i*i);
        }

        return new ModelAndView("page");
    }

    @RequestMapping(value = "/news/{newsId}/{newsTitle}.html", method = RequestMethod.GET)
    public ModelAndView loadNews(
            @PathVariable(name = "newsId") Long newsId,
            @PathVariable(name = "newsTitle") String newsTitle
    ){

        ModelAndView mw =  new ModelAndView("news");
        mw.addObject("newsId", newsId); //request.setAttribute("newsId", newsId);
        mw.addObject("title", newsTitle);
        return mw;

    }

    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request, HttpSession session){
        String someData = "Some Data";
        request.setAttribute("data", someData);
        return "test";
    }

    @RequestMapping(value = {"main", "/"}, method = RequestMethod.GET)
    public ModelAndView mainPage(HttpSession session, HttpServletRequest request, HttpServletResponse response){

        Users userData = getUserData(session, request, response);
        ModelAndView mw = new ModelAndView("main");

        if(userData!=null){
            mw.setViewName("profile");
            mw.addObject("userData", userData);
        }

        return mw;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(@RequestParam(name = "email") String email,
                       @RequestParam(name = "password") String password,
                       @RequestParam(name = "remember", required = false, defaultValue = "no") String remember,
                       HttpSession session,
                       HttpServletRequest request,
                       HttpServletResponse response){

        String message = "";

        Users user = DBManager.getUser(email, password);

        if(user!=null){

            session.setAttribute("USER_SESSION", user);
            if(remember.equals("yes")){
                String salt = "bitlab";
                String cookieData = email+salt+"_"+password+salt;
                cookieData = DigestUtils.sha1Hex(cookieData);

                Cookie cookie = new Cookie("authData", cookieData);
                cookie.setMaxAge(3600*24*365);
                response.addCookie(cookie);
            }

        }else{
            message = "?error=1";
        }

        return "redirect:/"+message;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, HttpServletResponse response){

        Cookie cookie = new Cookie("authData", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        session.removeAttribute("USER_SESSION");
        return "redirect:/";

    }

    private Users getUserData(HttpSession session, HttpServletRequest request, HttpServletResponse response){

        Users userData = null;

        if((userData=(Users) session.getAttribute("USER_SESSION"))!=null){

            userData = DBManager.getUser(userData.getEmail(), userData.getPassword());

            if(userData==null){
                session.removeAttribute("USER_SESSION");
            }

        }else{

            Cookie []cookies = request.getCookies();
            String cookieData = null;
            if(cookies!=null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("authData")) {
                        cookieData = c.getValue();
                        break;
                    }
                }
            }

            if(cookieData!=null){
                if((userData = DBManager.getUserByCookie(cookieData))!=null){
                    session.setAttribute("USER_SESSION", userData);
                }
            }else{
                Cookie cookie = new Cookie("authData", null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

        }
        return userData;
    }




}
