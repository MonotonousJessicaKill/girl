package jielin.girl.controller;

import jielin.girl.domain.Girl;
import jielin.girl.dao.GirlDao;
import jielin.girl.domain.Result;
import jielin.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import util.ResultUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GIrlController {
    @Autowired
    private GirlDao girlDao;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlDao.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.fail(1,bindingResult.getFieldError().getDefaultMessage());
        }
       return ResultUtil.success(girlDao.save(girl));

    }

    @GetMapping(value = "/girls/{id}")
    public Girl findOne(@PathVariable("id")int id){
        return girlDao.findOne(id);
    }
    @PutMapping(value = "/girls/{id}")
    public String updateOne(@PathVariable("id")int id,@RequestParam("cupSize") String cupSize,
                            @RequestParam("age") int age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girlDao.save(girl);
        return "add new one";
    }

    @DeleteMapping(value = "/girls/{id}")
    public String deleteOne(@PathVariable("id")int id){
        girlDao.delete(id);
        return "deleted";
    }

    // 通过年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findByAge(@PathVariable("age")int age){
        return girlDao.findByAge(age);
    }

    @PostMapping(value = "girls/two")
    public String addTwo(){
        girlService.insertTwo();
        return "added two girls.";
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id")int id)throws Exception{
        girlService.getAge(id);
    }
}
