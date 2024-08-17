package Api.RestFull.service;

import Api.RestFull.model.User;

public interface UserService {
     User findById(Long id);
     User create(User userToCreate);
}
