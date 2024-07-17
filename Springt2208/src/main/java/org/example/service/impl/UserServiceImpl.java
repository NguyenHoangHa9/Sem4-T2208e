package org.example.service.impl;

import com.mysql.cj.Session;
import org.example.config.properties.CommonProperties;
import org.example.dto.PageDto;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSpecification userSpecification;
    @Autowired
    private CommonProperties commonProperties;

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> saveAll(List<UserDto> userDtos) {
        // cach viet thong thuong ,  java 7 before
        List<User> users = new ArrayList<>();
        for (UserDto dto : userDtos) {
            User u = UserMapper.dtoToEntity(dto);
            users.add(u);
        }
        userRepository.saveAll(users);
        // Cach viet theo kieu lambda

//        userRepository.saveAll(userDtos
//                .stream()
//                .map(UserMapper::dtoToEntity)
//                .toList()
//        );
//
        return users;
//        Session session = entityManager.unwrap(Session.class)
//                .getSessiomFatory()
//                .openSession();
//        Transaction tx = session.beginTransaction();
//        String sql = "insert into user(user_name)"
//                int batchSize = 1000;
//        session.doWork(conn -> {
//              PreparedStatement pt = conn.prepareStatement(sql);
//            int i = 0;
//            int total = 0;
//
//       });
//        tx.commit();
//        session.close;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageDto search() {
        UserDto dto =  new UserDto();
        dto.setPageNumber(commonProperties.getDefaultPageNumber());
        dto.setPageSize(commonProperties.getDefaultPageSize());
        return search(dto);
    }

    @Override
    public PageDto search(UserDto dto) {
        if(dto.getPageSize() <= 0 || dto.getPageNumber() < 0){
            dto.setPageNumber(commonProperties.getDefaultPageNumber());
            dto.setPageSize(commonProperties.getDefaultPageSize());
        }
        Page<User> page = userRepository.findAll(userSpecification.filter(dto),
                PageRequest.of(dto.getPageNumber(),dto.getPageSize(),
                        Sort.by("username").descending()));
        // findAll  = select , count
        PageDto pageDto = new PageDto();
        pageDto.setContent(page.getContent()
                .stream()
                .map(UserMapper::entityToDto)
                .collect(Collectors.toList()));
        pageDto.setTotalElements(page.getTotalElements());
        pageDto.setNumber(page.getNumber());
        pageDto.setNumberOfElements(page.getNumberOfElements());
        pageDto.setPageNumber(page.getNumber());
        pageDto.setPageSize(page.getSize());
        pageDto.setTotalPages(page.getTotalPages());
        return pageDto;
    }

    @Override
    public PageDto searchUser(UserDto dto) {
        if (dto.getPageSize() <= 0 || dto.getPageNumber() < 0) {
            dto.setPageNumber(commonProperties.getDefaultPageNumber());
            dto.setPageSize(commonProperties.getDefaultPageSize());
        }

        Page<User> page = userRepository.findAll(
                userSpecification.filter(dto),
                PageRequest.of(dto.getPageNumber(), dto.getPageSize(), Sort.by("username").descending())
        );

        PageDto pageDto = new PageDto();
        pageDto.setContent(page.getContent()
                .stream()
                .map(UserMapper::entityToDto)
                .collect(Collectors.toList()));
        pageDto.setTotalElements(page.getTotalElements());
        pageDto.setNumber(page.getNumber());
        pageDto.setNumberOfElements(page.getNumberOfElements());
        pageDto.setPageNumber(page.getNumber());
        pageDto.setPageSize(page.getSize());
        pageDto.setTotalPages(page.getTotalPages());
        return pageDto;
    }

}
