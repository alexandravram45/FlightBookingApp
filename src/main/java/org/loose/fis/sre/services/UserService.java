package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.*;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role, String name, String email) throws UsernameAlreadyExistsException, NotAnAdminException {
        checkUserDoesNotAlreadyExist(username);
        checkUserIsNotAnAdmin(username, role);
        userRepository.insert(new User(username, encodePassword(username, password), role));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    private static void checkUserIsNotAnAdmin(String username, String role) throws NotAnAdminException {
        if (!(Objects.equals("balamoti.alexia", username) || Objects.equals("avram.alexandra", username)) && role == "Admin") {
                throw new NotAnAdminException(username, role);
            }
        }
    public static void checkLoginInfo(String username, String password, String role ) throws UsernameDoesNotExistException, WrongPasswordException, EmptyUsernameFieldException, EmptyPasswordFieldException {
        int userok=0, passok=0;
        if (username == "")
            throw new EmptyUsernameFieldException();
        if (password == "")
            throw new EmptyPasswordFieldException();
        for (User user : userRepository.find()){
            if(Objects.equals(username, user.getUsername())){
                userok =1;
                if(Objects.equals(encodePassword(username, password), user.getPassword())){
                    passok=1;
                }
            }
        }
        if (userok==0)
            throw new UsernameDoesNotExistException(username);
        if (passok==0)
            throw new WrongPasswordException();
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


}
