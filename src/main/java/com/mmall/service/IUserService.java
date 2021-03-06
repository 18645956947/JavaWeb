package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
    public ServerResponse<String> checkValid(String str, String type);
    public ServerResponse selectQuestion(String username);
    public ServerResponse<String> checkAnswer(String username, String question,String answer);
}
