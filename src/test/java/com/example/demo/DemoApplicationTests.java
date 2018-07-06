package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    ParentDao parentDao;

	@Test
	public void contextLoads() {

	    //Given
        Parent parent = new Parent();
        parent.setValue("dupa");

        Child child = new Child();
        child.setOtherValue("otherValue");

        parent.setChild(child);
        parentDao.save(parent);

        //When
        Parent parentExample = new Parent();
        Child childExample = new Child();
        childExample.setOtherValue("otherValue");
        parentExample.setChild(child);

        List<Parent> parents =  parentDao.findAll(Example.of(parentExample));

        //Then
        Assert.assertTrue(parents.size() == 1);
        Assert.assertTrue(parents.get(0).getChild() != null);
//        Assert.assertTrue(parents.get(0).getChild().getOtherValue().equals("otherValue"));
    }

}
