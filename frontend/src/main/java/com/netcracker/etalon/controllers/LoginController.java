package com.netcracker.etalon.controllers;

import com.netcracker.etalon.entities.UserEntity;
import com.netcracker.etalon.security.LoginUserService;
import com.netcracker.etalon.security.impl.CustomUser;
import com.netcracker.etalon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private LoginUserService loginUserService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/authorizeUser", method = RequestMethod.POST)
    public void  login(@RequestBody CustomUser loginData, HttpServletRequest request, HttpServletResponse response) {
        String role = "";
        try {
            loginUserService.authenticateUserAndSetSession(loginData.getUsername(), loginData.getPassword(), request, response);
            CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(customUser.getUsername());
            UserEntity userEntity = userService.find(customUser.getUsername()).get(0);
            System.out.println(userEntity.getRole());
            role = userEntity.getRole();
            //loginUserService.resolveHomeView((List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities());
         /*   if (role.equals("ROLE_ADMIN"))
                return "admin-page";*/
        } catch (BadCredentialsException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
  /*      return "eror";*/
       /* if (role.equals("ROLE_ADMIN"))
            return "redirect:/admin-page";
        return "eror";
*/



    }


}
