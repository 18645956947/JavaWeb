package com.mmall.controller.portal;


import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableInterceptor.ServerRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param username
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody//自定序列化为JSON
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username, password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @RequestMapping(value = "logout.do", method = RequestMethod.GET)
    @ResponseBody//自定序列化为JSON
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "register.do", method = RequestMethod.GET)
    @ResponseBody//自定序列化为JSON
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }

    @RequestMapping(value = "checkValid.do", method = RequestMethod.GET)
    @ResponseBody//自定序列化为JSON
    //校验用户名
    public ServerResponse<String> checkValid(String str, String type){
        return iUserService.checkValid(str, type);
    }

    @RequestMapping(value = "get_user_info.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null){
            return ServerResponse.createBySuccess(user);
        }
        return  ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户信息");
    }

    @RequestMapping(value = "forget_get_question.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username){
        return iUserService.selectQuestion(username);
    }
    @RequestMapping(value = "forget_check_answer.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username, String question,String answer){
        return iUserService.checkAnswer(username, question, answer);
    }


    public ServerResponse<String> forgetRestPassword(String usernaem, String passwordNew, String forgetToken){
        return null;
    }



}
