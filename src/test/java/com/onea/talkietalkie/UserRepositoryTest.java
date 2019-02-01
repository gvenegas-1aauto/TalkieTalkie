package com.onea.talkietalkie;

import com.onea.talkietalkie.model.User;
import com.onea.talkietalkie.repository.TechTalkRepository;
import com.onea.talkietalkie.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Inject
    private UserRepository userRepository;
    @Test
    public void shouldReadFromRepository() {
       Collection<User> users =  userRepository.findAll();
        Assert.assertTrue(users.size()>0);
    }
}
