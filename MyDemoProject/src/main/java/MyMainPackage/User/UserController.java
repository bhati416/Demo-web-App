package MyMainPackage.User;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public List<User> getAllUser()
	{
		List<User> user= userService.getAllUser();
		System.out.println("--"+user.size());
		return user;
	}
	
	
	@RequestMapping("/user/{id}")
	public User getUser(@PathVariable String id)
	{
		return userService.getUser(id);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public String addUser(@RequestBody User user)
	{
		System.out.println("inside addUser");
		userService.addUser(user);
		return "added successfully";
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/user/{id}")
	public void updateUser(@RequestBody User user,@PathVariable String id)
	{
		System.out.println("hii"+id);
		userService.updateUser(id,user);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/user/{id}")
	public void deleteUser(@PathVariable String id)
	{
		userService.deleteUser(id);
	}
	
	
	
}
