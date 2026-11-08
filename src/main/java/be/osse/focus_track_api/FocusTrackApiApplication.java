package be.osse.focus_track_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.security.autoconfigure.UserDetailsServiceAutoConfiguration.class
})
public class FocusTrackApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FocusTrackApiApplication.class, args);
    }

}
