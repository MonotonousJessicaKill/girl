package jielin.girl;

import jielin.girl.domain.Girl;
import jielin.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest //将启动整个spring工程
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void getAgeTest(){
        Girl girl=girlService.findOne(13);
        Assert.assertEquals(26,girl.getAge());
    }
}
