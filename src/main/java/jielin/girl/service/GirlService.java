package jielin.girl.service;

import jielin.girl.domain.Girl;
import jielin.girl.dao.GirlDao;
import jielin.girl.enums.ResultEnum;
import jielin.girl.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlDao girlDao;

    @Transactional
    public void insertTwo(){
        Girl girl1=new Girl();
        girl1.setAge(19);
        girl1.setCupSize("F");
        girlDao.save(girl1);

        Girl girl2=new Girl();
        girl2.setAge(26);
        girl2.setCupSize("D");
        girlDao.save(girl2);
    }

    public void getAge(int id)throws RuntimeException{
        Girl girl=girlDao.findOne(id);
        int age=girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_ERROR);
        }else if (age>10 && age<16){
            throw new GirlException(ResultEnum.SECOND_ERROR);
        }
    }

    public Girl findOne(int id){
        return girlDao.findOne(id);
    }
}
