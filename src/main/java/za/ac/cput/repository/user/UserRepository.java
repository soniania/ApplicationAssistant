package za.ac.cput.repository.user;


import za.ac.cput.entity.user.User;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface UserRepository extends IRepository<User, String> {
        Set<User> getAll();
}