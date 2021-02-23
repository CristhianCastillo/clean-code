package com.cleancode.controller;

import com.cleancode.domain.dto.request.UserRequest;
import com.cleancode.domain.dto.response.ResponseDto;
import com.cleancode.domain.dto.response.UserResponse;
import com.cleancode.domain.manage.ManageUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private final ManageUserService manageUserService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<ResponseDto<List<UserResponse>>> getAllUsers() {
        return new ResponseEntity<>(ResponseDto.success(this.manageUserService.getAllUsers()), HttpStatus.OK);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<ResponseDto<UserResponse>> getUserById(@PathVariable Long userId) {
        return new ResponseEntity<>(ResponseDto.success(this.manageUserService.getUserById(userId)), HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<ResponseDto<UserResponse>> createUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(ResponseDto.success(this.manageUserService.createUser(userRequest)), HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<ResponseDto<UserResponse>> updateUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(ResponseDto.success(this.manageUserService.updateUser(userRequest)), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<ResponseDto<String>> deleteUser(@PathVariable Long userId) {
        this.manageUserService.deleteUser(userId);
        return new ResponseEntity<>(ResponseDto.success("Successfully removed"), HttpStatus.OK);
    }

    // TODO: 15. Mantenga las funciones pequeñas - cortas (Ideal: 4 líneas, Máximo: 60 líneas (25 0 35), toda la función debe caber
    //  en la pantalla, para que sea fácil de leer sin desplazamiento vertical)
    //  y no demasiado ancha (Hasta 70 a 120 caracteres, es fácil leer toda la línea sin desplazamiento horizontal).

    // TODO: 18. Una función debe hacer solo una cosa (mantenerla atómica)
//    @ResponseBody
//    @PostMapping(AdministrationConstants.SING_IN_REST)
//    public ResponseDto<UserDTO> singIn(@Valid @RequestBody LoginDTO user, HttpServletRequest request) throws Exception {
//        String userOrEmail = user.getUserOrEmail();
//        String password = user.getPassword();
//        if (StringUtils.isEmpty(userOrEmail) || StringUtils.isEmpty(password))
//            throw new Exception(messageSource.getMessage("admin.login.faild", null, new Locale("es")));
//        UserDTO userValidateLogin = userService.findByUserName(userOrEmail);
//        if (userValidateLogin == null) {
//            userValidateLogin = userService.findByEmail(userOrEmail);
//            if (userValidateLogin == null)
//                throw new Exception(messageSource.getMessage("admin.login.faild", null, new Locale("es")));
//        }
//        if (!userValidateLogin.getConfirmationEmail())
//            throw new Exception(messageSource.getMessage("user.email.false", null, new Locale("es")));
//        if (!userValidateLogin.getStatus())
//            throw new Exception(messageSource.getMessage("user.status.false", null, new Locale("es")));
//        if (!userValidateLogin.getPasswordEntity().getEnable())
//            throw new Exception(messageSource.getMessage("password.value.false", null, new Locale("es")));
//        PasswordDTO passwordUser = userValidateLogin.getPasswordEntity();
//        String hashPasswordEntry = SecurityUtils.hashPassword(password);
//        if (hashPasswordEntry.equals(userValidateLogin.getPasswordEntity().getPassword())) {
//            if (passwordUser.getExpiredDate().compareTo(new Date()) <= 0)
//                throw new Exception(messageSource.getMessage("password.expired", null, new Locale("es")));
//            String token = tokenService.createUserToken(UserService.convertDTOToEntity(userValidateLogin));
//            userValidateLogin.setToken(token);
//            passwordUser.setFailedAttempst(0L);
//            userValidateLogin.setPasswordEntity(passwordUser);
//            userValidateLogin = userService.update(userValidateLogin);
//
//            // TODO 17. Evite las duplicaciones.
//            BinnacleDTO binnacle = new BinnacleDTO(request.getRemoteAddr(), "user", "update", new Date(),
//                    userValidateLogin);
//            Runnable r = () -> {
//                try {
//                    binnacleService.save(binnacle);
//                } catch (Exception e) {
//                    LOGGER.error("ERROR AL REGISTRAR LA BITACORA, ERROR CODE: {} - ERROR DESCRIPTION: {}", ExceptionCode.ERROR_REGISTER_BINNACLE.getCode(), ExceptionUtils.getStackTrace(e));
//                }
//            };
//            Thread t1 = new Thread(r);
//            t1.start();
//            return ResponseDto.success(userValidateLogin);
//        } else {
//            int limitLogin = 0;
//            String limitLoginStr = parameterService.findOneByName(AdministrationConstants.LIMIT_FAILED_ATTEMPST)
//                    .getValue();
//            if (limitLoginStr != null)
//                limitLogin = Integer.parseInt(limitLoginStr);
//            Long failedAttempst = passwordUser.getFailedAttempst();
//            failedAttempst++;
//            if (failedAttempst >= limitLogin)
//                passwordUser.setEnable(false);
//            passwordUser.setFailedAttempst(failedAttempst);
//            userValidateLogin.setToken("");
//            userValidateLogin.setPasswordEntity(passwordUser);
//            userValidateLogin = userService.update(userValidateLogin);
//
//            // TODO 17. Evite las duplicaciones.
//            BinnacleDTO binnacle = new BinnacleDTO(request.getRemoteAddr(), "user", "update", new Date(),
//                    userValidateLogin);
//            Runnable r = () -> {
//                try {
//                    binnacleService.save(binnacle);
//                } catch (Exception e) {
//                    LOGGER.error("ERROR AL REGISTRAR LA BITACORA, ERROR CODE: {} - ERROR DESCRIPTION: {}", ExceptionCode.ERROR_REGISTER_BINNACLE.getCode(), ExceptionUtils.getStackTrace(e));
//                }
//            };
//            Thread t1 = new Thread(r);
//            t1.start();
//            throw new Exception(messageSource.getMessage("admin.login.faild", null, new Locale("es")));
//        }
//    }
}
