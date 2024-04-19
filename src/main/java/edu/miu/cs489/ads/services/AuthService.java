package edu.miu.cs489.ads.services;


import edu.miu.cs489.ads.dto.request.LoginRequest;
import edu.miu.cs489.ads.dto.request.RegisterRequest;
import edu.miu.cs489.ads.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    void register(RegisterRequest registerRequest);
}
