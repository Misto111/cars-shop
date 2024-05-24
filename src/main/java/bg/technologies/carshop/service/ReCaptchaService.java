package bg.technologies.carshop.service;

import bg.technologies.carshop.model.dto.ReCaptchaResponseDTO;

import java.util.Optional;

public interface ReCaptchaService {
  Optional<ReCaptchaResponseDTO> verify(String token);
}
