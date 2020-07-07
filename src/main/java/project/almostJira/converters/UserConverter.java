package project.almostJira.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import project.almostJira.models.User;
import project.almostJira.services.UserService;

@Component
public class UserConverter implements Converter<String , User> {

    @Autowired
    UserService userService;

    @Override
    public User convert(String s) {
        return userService.findById(Integer.parseInt(s));
    }
}
