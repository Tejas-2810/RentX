package com.rentx.businessservices;



import com.rentx.entities.User;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import com.rentx.dataaccess.repository.UserRepository;

public class UserProfileServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserProfileService userProfileService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindUserById() {
        User user = new User();
        user.setUserID(1001);
        user.setFirstName("Alice");
        user.setLastName("Smith");
        user.setPhone("5554203678");
        user.setPrefLanguage("english");
        user.setAreaId(505);
        user.setPrivacy("disabled");
        user.setIsExists(1);

        when(userRepository.findById(1001)).thenReturn(Optional.of(user));

        User result = userProfileService.findUserById(1001);

        assertEquals(user, result);
        verify(userRepository, times(1)).findById(1001);
    }

    @Test
    public void testFindUserByIdNotFound() {
        when(userRepository.findById(1000)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userProfileService.findUserById(1000));
        verify(userRepository, times(1)).findById(1000);
    }

    @Test
    public void testUpdateUserProfile() {
        User existingUser = new User();
        existingUser.setUserID(1002);
        existingUser.setFirstName("Bob");
        existingUser.setLastName("Johnson");
        existingUser.setPhone("5559812673");
        existingUser.setPrefLanguage("english");
        existingUser.setAreaId(504);
        existingUser.setPrivacy("enabled");
        existingUser.setIsExists(1);

        User newUser = new User();
        newUser.setFirstName("Jane");
        newUser.setLastName("Doe");
        newUser.setPhone("0987654321");
        newUser.setPrefLanguage("french");
        newUser.setAreaId(504);
        newUser.setPrivacy("enabled");
        newUser.setIsExists(1);

        when(userRepository.findById(1002)).thenReturn(Optional.of(existingUser));

        userProfileService.updateUserProfile(1002, newUser);

        verify(userRepository, times(1)).findById(1002);
        verify(userRepository, times(1)).save(existingUser);

        assertEquals(newUser.getFirstName(), existingUser.getFirstName());
        assertEquals(newUser.getLastName(), existingUser.getLastName());
        assertEquals(newUser.getPhone(), existingUser.getPhone());
        assertEquals(newUser.getPrefLanguage(), existingUser.getPrefLanguage());
        assertEquals(newUser.getAreaId(), existingUser.getAreaId());
        assertEquals(newUser.getPrivacy(), existingUser.getPrivacy());
        assertEquals(newUser.getIsExists(), existingUser.getIsExists());
    }

    @Test
    public void testUpdateUserProfileNotFound() {
        User newUser = new User();
        newUser.setFirstName("Jane");
        newUser.setLastName("Doe");
        newUser.setPhone("0987654321");
        newUser.setPrefLanguage("french");
        newUser.setAreaId(506);
        newUser.setPrivacy("disabled");
        newUser.setIsExists(1);

        when(userRepository.findById(1000)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userProfileService.updateUserProfile(1000, newUser));
        verify(userRepository, times(1)).findById(1000);
        verify(userRepository, never()).save(any(User.class));
    }
}