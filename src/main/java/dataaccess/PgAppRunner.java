package dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PgAppRunner implements ApplicationRunner {
    private final chinookDAO chinookDAO;


    public PgAppRunner(chinookDAO chinookDAO){
        this.chinookDAO = chinookDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
    }
}
