import com.vuetutorial.VueTutorialApplication;
import com.vuetutorial.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VueTutorialApplication.class)
public class KeyanTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test1() {
        System.out.println(userMapper.selectById(1));
    }
}
