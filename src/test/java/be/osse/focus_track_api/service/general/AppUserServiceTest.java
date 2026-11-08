package be.osse.focus_track_api.service.general;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.repository.general.AppUserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTest {

    @Mock
    AppUserRepo appUserRepo;

    private AppUserService appUserService;

    @BeforeEach
    void setUp() {
        appUserService = new AppUserService(appUserRepo);
    }

    @Test
    void testFindAll() {
        // GIVEN
        List<AppUser> expected = List.of(mock(AppUser.class));
        when(appUserRepo.findAll()).thenReturn(expected);

        // WHEN
        List<AppUser> result = appUserService.findAll();

        // THEN
        verify(appUserRepo).findAll();
        assertEquals(expected, result);
    }

    @Test
    void testFindByUuid() {
        // GIVEN
        String uuid = "uuid";
        AppUser expected = mock(AppUser.class);
        when(appUserRepo.findByUuid(uuid)).thenReturn(expected);

        // WHEN
        AppUser result = appUserService.findByUuid(uuid);

        // THEN
        verify(appUserRepo).findByUuid(uuid);
        assertEquals(expected, result);
    }

    @Test
    void testSave() {
        // GIVEN
        AppUser user =  mock(AppUser.class);
        AppUser expected = mock(AppUser.class);
        when(appUserRepo.save(user)).thenReturn(expected);

        // WHEN
        AppUser result = appUserService.save(user);

        // THEN
        verify(appUserRepo).save(user);
        assertEquals(expected, result);
    }
}
