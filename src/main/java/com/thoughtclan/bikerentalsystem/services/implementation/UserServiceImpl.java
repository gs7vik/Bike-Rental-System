package com.thoughtclan.bikerentalsystem.services.implementation;

import com.google.firebase.auth.UserRecord;
import com.google.gson.Gson;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.LoginInputDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInput;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.LoginOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.SignInFireBaseOutput;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutputDto;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.Role;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.repositories.RoleRepository;
import com.thoughtclan.bikerentalsystem.repositories.UserRepository;
import com.thoughtclan.bikerentalsystem.services.FireBaseService;
import com.thoughtclan.bikerentalsystem.services.UserService;
import com.thoughtclan.bikerentalsystem.utils.CurrentUser;
import com.thoughtclan.bikerentalsystem.utils.PatchMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String FIREBASE_URL ="https://identitytoolkit.googleapis.com/v1/accounts" ;
    private static final String FIREBASE_API_KEY = "AIzaSyAVehVl9wrJAYLwoCiQknV7Hu18-UQP-1k";

    private final UserRepository userRepository;


    private final ModelMapper modelMapper;


    private final PatchMapper patchMapper;



    private final RoleRepository roleRepository;

    private final FireBaseService fireBaseService;


    @Override
    public User getByFireBaseId(String uid){
        return userRepository.findByFireBaseId(uid).orElseThrow(()-> new EntityNotFoundException("firebase id not found"));
    }
    public UserOutputDto saveUser(UserInputDto user) {

        User user1 = modelMapper.map(user, User.class);
        UserInput userInput = new UserInput();
        userInput.setEmail(user1.getEmail());
        userInput.setPassword(user1.getPassword());
        userInput.setName(user.getFirstName());


        UserRecord userRecord = fireBaseService.createInFireBase(userInput);
        user1.setFireBaseId(userRecord.getUid());




        Role role = roleRepository.findById(user.getRoleId()).orElse(null);
        user1.setRole(role);


        user1 = userRepository.save(user1);
        UserOutputDto user3 =  modelMapper.map(user1, UserOutputDto.class);
        return user3;
    }

    public UserOutputDto getUser(Long id) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        return modelMapper.map(user1, UserOutputDto.class);
    }

    @Override
    public LoginOutputDto login(LoginInputDto input) {
        System.out.println(FIREBASE_URL);
        System.out.println(FIREBASE_API_KEY);
        String url = FIREBASE_URL+":signInWithPassword?key="+FIREBASE_API_KEY;
        Map<String, Object> map = new HashMap<>();
        map.put("email",input.getEmail());
        map.put("password",input.getPassword());
        map.put("returnSecureToken",true);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<?> httpEntity = new HttpEntity<>(map,httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST,httpEntity,String.class);
        String body = exchange.getBody();
        Gson gson = new Gson();
        SignInFireBaseOutput signInFireBaseOutput = gson.fromJson(body,SignInFireBaseOutput.class);
        LoginOutputDto loginOutputDto = new LoginOutputDto();
        loginOutputDto.setAccessToken(signInFireBaseOutput.getIdToken());
        loginOutputDto.setRefreshToken(signInFireBaseOutput.getRefreshToken());
        loginOutputDto.setExpiresIn(signInFireBaseOutput.getExpiresIn());

        return loginOutputDto;
    }

    @Override
    public UserOutDto partialUpdateUser(UserInDto input, Long id) {
        User users=modelMapper.map(input, User.class);
        User existingUser=userRepository.findById(id).orElseThrow(()->new RuntimeException("No user by such Id"));
        patchMapper.map(users,existingUser);
        existingUser=userRepository.save(existingUser);
        return modelMapper.map(existingUser, UserOutDto.class);
    }

    @Override
    public UserOutDto updateUser(Long id, UserInDto input) {
        User users=modelMapper.map(input, User.class);
        User existingUser=userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No such user with that id"));
        modelMapper.map(users,existingUser);
        existingUser=userRepository.save(existingUser);
        return modelMapper.map(existingUser, UserOutDto.class);
    }

    @Override
    public UserOutputDto userMe(){
        return modelMapper.map(CurrentUser.get(),UserOutputDto.class);

    }

}