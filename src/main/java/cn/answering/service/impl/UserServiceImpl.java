package cn.answering.service.impl;

import cn.answering.domain.User;
import cn.answering.repository.UserRepository;
import cn.answering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User saveOrUpdata(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public Page<User> findUserByPage(Pageable pageable) {
        return (Page<User>) userRepository.findAll();
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
