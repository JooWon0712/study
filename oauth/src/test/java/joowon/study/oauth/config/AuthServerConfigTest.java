package joowon.study.oauth.config;

import joowon.study.oauth.accounts.Account;
import joowon.study.oauth.accounts.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by JooWon0712.
 * User: joowon
 * Date: 2019-02-26
 * Time: 16:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthServerConfigTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    @Transactional
    public void setup() {
        Account account = Account.builder()
                .userName("joowon")
                .userPassword("1234")
                .build();

        Account saveAccount = accountService.saveAccount(account);
    }

    @Test
    @Description("인증 토큰 발급 받기(성공)")
    public void getAuthToken_ok() throws Exception {
        this.mockMvc.perform(post("/oauth/token")
                    .with(httpBasic("joowon-client", "joowon-secret"))
                    .param("username", "joowon")
                    .param("password", "1234")
                    .param("grant_type", "password"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("access_token").exists());
    }

    @Test
    @Description("인증 토큰 발급 받기(실패 - 계정 정보 잘못 입력)")
    public void getAuthToken_fail() throws Exception {
        this.mockMvc.perform(post("/oauth/token")
                .with(httpBasic("joowon-client", "joowon-secret"))
                .param("username", "joowon0")
                .param("password", "1234")
                .param("grant_type", "password"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}