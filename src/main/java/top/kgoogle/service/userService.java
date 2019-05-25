package top.kgoogle.service;

import org.springframework.stereotype.Component;
import top.kgoogle.data.user;
@Component
public interface userService {
    public void register(user user);
}
