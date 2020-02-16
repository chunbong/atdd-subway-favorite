package atdd.path.web;

import atdd.path.AbstractAcceptanceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static atdd.path.TestConstant.STATION_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class UserAcceptanceTest extends AbstractAcceptanceTest {

    public static final String USER_URL = "/users";

    private UserHttpTest userHttpTest;

    @BeforeEach
    void setUp() {
        this.userHttpTest = new UserHttpTest(webTestClient);
    }

    @DisplayName("회원 가입")
    @Test
    public void createUser() {
        // When
        Long userId = userHttpTest.createUser(userRequestView);

        // then
        EntityExchangeResult<UserResponseView> response = userHttpTest.retrieveStation(userId);
        assertThat(response.getResponseBody().getEmail()).isEqualTo(userRequestView.getEmail());
    }
}
