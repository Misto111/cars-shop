package bg.technologies.carshop.web;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${mail.port}")
    private int port;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.userName}")
    private String userName;


    @Value("${mail.password}")
    private String password;


    private GreenMail greenMail;

    @BeforeEach
    void setUp() {

        greenMail = new GreenMail(new ServerSetup(port, host, "smtp"));
        greenMail.start();
        greenMail.setUser(userName, password);
    }


    @Test
    void testRegistration() throws Exception {


        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/register")
                        .param("email", "test@gmail.com")
                        .param("firstName", "Hachi")
                        .param("lastName", "Kuchev")
                        .param("password", "12345")
                        .param("confirmPassword", "12345")
                        .with(csrf())
        ).andExpect(status().is3xxRedirection());
    }

}