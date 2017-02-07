package MyMainPackage.User;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
@Transactional
public interface UserRepo extends CrudRepository<User,String> {

}
