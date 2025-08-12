package com.example.vebdomaci6;

import com.example.vebdomaci6.repositories.post.MySqlPostRepo;
import com.example.vebdomaci6.repositories.post.PostRepo;
import com.example.vebdomaci6.repositories.user.UserRepo;
import com.example.vebdomaci6.repositories.user.UserRepoImpl;
import com.example.vebdomaci6.services.PostService;
import com.example.vebdomaci6.services.UserService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    public HelloApplication() {
        // Ukljucujemo validaciju
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        // Definisemo implementacije u dependency container-u
        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                this.bind(MySqlPostRepo.class).to(PostRepo.class).in(Singleton.class);
                this.bind(UserRepoImpl.class).to(UserRepo.class).in(Singleton.class);

                this.bindAsContract(PostService.class);
                this.bindAsContract(UserService.class);
            }
        };
        register(binder);

        // Ucitavamo resurse
        packages("com.example.vebdomaci6.resources");
    }

}