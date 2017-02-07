package MyMainPackage.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	/*
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			
			new Topic("rashmi","sunil","bhalerao"),
			new Topic("prashant","jitendra","bhati"),
			new Topic("swapnil","machindranath","chaudhari")				
		));*/
	public List<User> getAllUser()
	{
		List<User> user=new ArrayList<>();
		userRepo.findAll().forEach(user::add);
		return user;
	}

	public User getUser(String id)
	{
		return userRepo.findOne(id);
	}

	public void addUser(User user) {
		 userRepo.save(user);
		
	}

	public void updateUser(String id, User user) {
	/*	for(int i=0;i < topics.size();i++)
		{
			Topic t = topics.get(i);
			if(t.getFname().equals(id))
			{
				topics.set(i,topic);
				return;
			}
			
		}*/
		user.setId(id);
		userRepo.save(user);
		
	}

	public void deleteUser(String id) {
		//topics.removeIf(t -> t.getFname().equals(id));
		userRepo.delete(id)	;
	}
	
}
