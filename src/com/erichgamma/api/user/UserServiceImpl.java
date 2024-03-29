package com.erichgamma.api.user;

import com.erichgamma.api.common.AbstractService;
import com.erichgamma.api.common.UtilServiceImpl;
import com.erichgamma.api.enums.Messenger;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    private static UserServiceImpl instance = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return instance;
    }

    private Map<String, User> users;
    private UserRepository userRepository;

    private UserServiceImpl() {
        this.users = new HashMap<>();
        this.userRepository = UserRepository.getInstance();
    }

    @Override
    public Messenger save(User user) throws SQLException {
        userRepository.save(user);
        return Messenger.SUCCESS;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                "로그인 성공" : "로그인 실패";
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(users.values()
                .stream()
                .filter(i -> i.getId().equals(id))
                .collect(Collectors.toList()).get(0));
    }

    @Override
    public String updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());
        return "비번 변경 성공";
    }

    @Override
    public String delete(User user) {
        users.remove(user.getUsername());
        return "회원삭제";
    }


    @Override
    public Boolean existsById(Long id) {
        return users.containsKey(id);
    }


    @Override
    public List<?> findUsersByName(String name) {
        return users.values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getValue().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public List<?> findUsersByJob(String job) {
        System.out.println("findUsersByJob 파라미터 " + job);
        users
                .values()
                .stream().forEach(i -> System.out.println("직업: " + i.getJob()));
        return users
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getValue().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String count() {
        return users.size() + "";
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.of(users.get(id));
    }

    @Override
    public Map<String, ?> getUserMap() {
        return users;
    }

    @Override
    public String addUsers() {
        IntStream.range(0, 5)
                .mapToObj(i -> UtilServiceImpl.getInstance().createRandomUsername())
                .forEach(i -> users.put(i, User.builder()
                        .username(i)
                        .password("1")
                        .name(UtilServiceImpl.getInstance().createRandomName())
                        .job(UtilServiceImpl.getInstance().createRandomJob())
                        .build()));
        return users.size() + "개 더미값 추가";

    }

    @Override
    public List<?> findUsers() throws SQLException {
        return userRepository.findUsers();
    }

    @Override
    public Messenger createTable() throws SQLException {
        return userRepository.createTable();
    }

    @Override
    public Messenger delTable() throws SQLException {
        return userRepository.delTable();
    }

}