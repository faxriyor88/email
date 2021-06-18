package com.example.email.service;

import com.example.email.dto.RegisterDto;

import com.example.email.entity.User;
import com.example.email.entity.enums.Rolename;
import com.example.email.repository.RoleRepository;
import com.example.email.repository.UserRepository;
import com.example.email.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ApiResponse registr(RegisterDto registerDto) {
        boolean existsByEmail = userRepository.existsByEmail(registerDto.getEmail());
        if (existsByEmail) {
            return new ApiResponse("Bunday email mavjud", false);
        } else {
            String emailCode = UUID.randomUUID().toString();
            User user = new User(registerDto.getFirstname(), registerDto.getLastname(), registerDto.getEmail(),
                    passwordEncoder.encode(registerDto.getPassword()),
                    Collections.singleton(roleRepository.findByRolename(Rolename.ROLE_USER)), emailCode);
            userRepository.save(user);
            sendEmail(registerDto.getEmail(), emailCode);
            return new ApiResponse("Muvaffaqiyatli ro'yxatdan o'tdingiz.Akkountni tasdiqlang", true);
        }
    }
    public ApiResponse verifyEmail(String sendingEmail,String emailCode){
        Optional<User> optional=userRepository.findByEmailAndEmailCode(sendingEmail,emailCode);
        if (optional.isPresent()){
            User user= optional.get();
            user.setEnabled(true);
            user.setEmailCode(null);
            userRepository.save(user);
            return new ApiResponse("Account tasdiqlandi",true);
        }else {
            return new ApiResponse("Account tasdiqlanmadi",false);
        }
    }

    public boolean sendEmail(String sendingEmail,String emailCode){
      try {
          SimpleMailMessage message = new SimpleMailMessage();
          message.setFrom("test");
          message.setTo(sendingEmail);
          message.setSubject("Tasdiqlash kodi");
          message.setText("<a href='http://localhost:8080/api/auth/verifyemail?emailCode=" + emailCode + "&sendingEmail=" + sendingEmail + "'>Tasdiqlang</a>");
          javaMailSender.send(message);
          return true;
      }catch (Exception e){
          return false;
      }
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Topilmadi"));
    }
}
