package jielin.girl.dao;

import jielin.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlDao extends JpaRepository<Girl,Integer>{
    // 通过年龄查询
    public List<Girl> findByAge(Integer  age);
}
