package com.cleancode.domain.service.imp;

import com.cleancode.domain.service.InscriptionService;
import com.cleancode.persistence.crud.InscriptionRepository;
import com.cleancode.persistence.entity.InscriptionEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class InscriptionServiceImp implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    @Override
    public List<InscriptionEntity> getByUserId(Long userId) {
        return this.inscriptionRepository.findByUserId(userId);
    }

    @Override
    public InscriptionEntity getByUserIdAndCourseId(Long userId, Long courseId) {
        return this.inscriptionRepository.userIdAndCourseId(userId, courseId);
    }

    @Override
    public InscriptionEntity save(InscriptionEntity inscriptionEntity) {
        return this.inscriptionRepository.save(inscriptionEntity);
    }

    @Override
    public InscriptionEntity update(InscriptionEntity inscriptionEntity) {
        return this.inscriptionRepository.save(inscriptionEntity);
    }

    // TODO: 5. Constantes, nombres que se puedan buscar.
    @Override
    public void delete(InscriptionEntity inscriptionEntity) {
        inscriptionEntity.setStatus("disabled");
        this.inscriptionRepository.save(inscriptionEntity);
    }

    // TODO: 22. Cero codigo comentado.
    // Next week I need this.
    /*@GetMapping(ApplicationConstants.VERIFICATION_SERVICES_EMAIL + "/{token}")
    public ModelAndView validateRegisterUser(@PathVariable String token, HttpServletRequest request) {
        String urlConfirmEmail = parameterService.findOneByName(AdministrationConstants.URL_CONFIRM_EMAIL).getValue();
        if (StringUtils.isEmpty(token))
            return new ModelAndView("redirect:" + urlConfirmEmail + messageSource.getMessage("token.invalid", null, new Locale("es")));
        else {
            String username = tokenService.getUserEmailFromToken(token);
            if (StringUtils.isEmpty(username))
                return new ModelAndView("redirect:" + urlConfirmEmail + messageSource.getMessage("token.user.invalid", null, new Locale("es")));
            UserDTO userEntity = userService.findByUserName(username);
            if (StringUtils.isEmpty(userEntity))
                return new ModelAndView("redirect:" + urlConfirmEmail + messageSource.getMessage("token.user.invalid", null, new Locale("es")));
            if (StringUtils.isEmpty(userEntity.getTokenEmail()))
                return new ModelAndView("redirect:" + urlConfirmEmail + messageSource.getMessage("token.email.invalid", null, new Locale("es")));
            if (userEntity.getStatus())
                return new ModelAndView("redirect:" + urlConfirmEmail + messageSource.getMessage("token.user.status.invalid", null, new Locale("es")));
            if (userEntity.getConfirmationEmail())
                return new ModelAndView("redirect:" + urlConfirmEmail + messageSource.getMessage("token.reconfirmation", null, new Locale("es")));
            if (userEntity.getPasswordEntity().getEnable())
                return new ModelAndView("redirect:" + urlConfirmEmail + messageSource.getMessage("token.reconfirmation.password", null, new Locale("es")));
            userEntity.setStatus(true);
            userEntity.setConfirmationEmail(true);
            PasswordDTO password = userEntity.getPasswordEntity();
            password.setEnable(true);
            int limitMonths = 1;
            String limitMonthsStr = parameterService.findOneByName(AdministrationConstants.PASSWORD_EXPIRED)
                    .getValue();
            if (limitMonthsStr != null)
                limitMonths = Integer.parseInt(limitMonthsStr);
            Date expiredDate = DateUtils.addMonths(new Date(), limitMonths);
            password.setExpiredDate(expiredDate);
            userEntity.setPasswordEntity(password);
            UserDTO userNew = this.userService.update(userEntity);

            BinnacleDTO binnacle = new BinnacleDTO(request.getRemoteAddr(), "user", "update", new Date(),
                    userNew);
            Runnable r = () -> {
                try {
                    binnacleService.save(binnacle);
                } catch (Exception e) {
                    LOGGER.error("ERROR AL REGISTRAR LA BITACORA, ERROR CODE: {} - ERROR DESCRIPTION: {}", ExceptionCode.ERROR_REGISTER_BINNACLE.getCode(), ExceptionUtils.getStackTrace(e));
                }
            };
            Thread t1 = new Thread(r);
            t1.start();

            if (StringUtils.isEmpty(userNew))
                return new ModelAndView("redirect:" + urlConfirmEmail + messageSource.getMessage("token.07.invalid", null, new Locale("es")));

            Runnable r1 = () -> {
                try {
                    emailService.sendEmailValidation(userNew);
                } catch (Exception e) {
                    LOGGER.error("ERROR AL ENVIAR EL CORREO VERIFICACION USUARIO, ERROR CODE: {} - ERROR DESCRIPTION: {}", ExceptionCode.ERROR_SEND_EMAIL.getCode(), ExceptionUtils.getStackTrace(e));
                }
            };
            Thread t2 = new Thread(r1);
            t2.start();
            return new ModelAndView("redirect:" + urlConfirmEmail + messageSource.getMessage("token.correct.verification", null, new Locale("es")));
        }
    }*/
}
