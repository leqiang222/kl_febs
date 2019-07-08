import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author LeQiang Li
 * @Date Created in 09:49 2019/7/8
 * @Description:
 * @Modified By:
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class JCFebsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JCFebsApplication.class)
                .run(args);
    }
}
