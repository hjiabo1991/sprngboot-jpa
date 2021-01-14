package com.hjb.jpa;

import com.hjb.jpa.dao.PetDao;
import com.hjb.jpa.entity.Pet;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javassist.runtime.Desc;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SpringBootTest(classes = SpringbootjpaApplication.class)
class SpringbootjpaApplicationTests {


    void contextLoads() {
        System.out.println("table create success...");
    }

    // 对jpa提供的接口方法进行测试

    // 动态代理，自动注入
    @Autowired
    PetDao petDao;
    /**
     * 测试添加
     */
    @Test
    public void addPet() {
        Pet pet = new Pet();
        // id属性不需要设置，自增
        pet.setPname("小兰");
        pet.setColor("blue");
        petDao.save(pet);
        System.out.println("save data to table success");
    }

    public void findAllPet() {
        List<Pet> list = petDao.findAll();
        System.out.println("find all pets");
        System.out.println(list);
    }

    /**
     * 根据ids查询
     */
    public void findByIds() {
        List<Integer> ids = Lists.newArrayList();
        ids.add(1);
        ids.add(2);
        List<Pet> allById = petDao.findAllById((Iterable<Integer>) ids);
        System.out.println(allById);
    }
    @Test
    public void findSort() {
        List<String> properties = Lists.newArrayList();
        properties.add("id");

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        List<Pet> allById = petDao.findAll(Sort.by(order));
        allById.stream().forEach( pet -> {
            System.out.println(pet);
        });
    }

    /**
     * 分页查
     */

    public void findByPage() {
        // (int page, int size, Direction direction, String... properties)
        // 0表示第一页，
        // Sort.Direction.DESC表示降序
        Pageable id = PageRequest.of(0, 2, Sort.Direction.DESC, "id");
        Page<Pet> all = petDao.findAll(id);
        all.stream().forEach( pet -> {
            System.out.println(pet);
        });
        System.out.println("getTotal page:" + all.getTotalPages());
    }

    /**
     * 删除
     */

    public void deleteById() {
        petDao.deleteById(new Integer(1));
        System.out.println("delete by id...");
    }

    public void deleteByEntity() {
        Pet pet = new Pet();
        pet.setId(2);
        petDao.delete(pet);
        System.out.println("delete by pet");
    }

    /**
     * 根据自定义查询:pname
     */
    public void findByPname() {
        String pName = "小兰";
        List<Pet> pets = petDao.findByPname(pName);
        System.out.println(pets);

    }
    @Test
    public void findByColor() {
        String color = "blue";
        List<Pet> pets = petDao.findByColor(color);
        System.out.println(pets);
    }

    /**
     * 联合查询
     */
    public void findByPnameAndColor() {
        String pname = "小兰";
        String color = "red";
        List<Pet> pets = petDao.findByPnameAndAndColor(pname, color);
        System.out.println(pets);

    }

    /**
     * 自定义查询: 根据id的between and 并根据OrderBy id排序
     */

    public void findByIdBetweenOrderById() {
        Integer minId = 1;
        Integer maxId = 5;
        List<Pet> pets = petDao.findByIdBetweenOrderById(minId, maxId);
        System.out.println(pets);
    }

    /**
     * JPQL查询
     */

    public void getPets() {
        List<Pet> pets = petDao.findAll();
        System.out.println(pets);
    }
    public void getPetsPname() {
        List<Object[]> pname = petDao.getPname();
        pname.stream().forEach(item -> {
            System.out.println(Arrays.toString(item));
        });
    }
}
