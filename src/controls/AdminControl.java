package controls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.User;

@Controller
@RequestMapping(value = "/admin")
public class AdminControl {
	@RequestMapping(value = "/users")
	public String users(Model model) {
		User aUser = new User(001, "robbie1", "123456", "test1@mail.com");
		User bUser = new User(002, "robbie2", "123456", "test2@mail.com");
		User cUser = new User(003, "robbie3", "123456", "test3@mail.com");
		User dUser = new User(004, "robbie4", "123456", "test4@mail.com");
		User eUser = new User(005, "robbie5", "123456", "test5@mail.com");

		List<User> users = new ArrayList<User>();
		users.add(eUser);
		users.add(dUser);
		users.add(cUser);
		users.add(bUser);
		users.add(aUser);
		model.addAttribute("users", users);

		return "/admin/users.jsp";
	}
	@RequestMapping(value = "/getusers")
	@ResponseBody
	public List<User> getusers() {
		User aUser = new User(001, "robbie1", "123456", "test1@mail.com");
		User bUser = new User(002, "robbie2", "123456", "test2@mail.com");
		User cUser = new User(003, "robbie3", "123456", "test3@mail.com");
		User dUser = new User(004, "robbie4", "123456", "test4@mail.com");
		User eUser = new User(005, "robbie5", "123456", "test5@mail.com");

		List<User> users = new ArrayList<User>();
		users.add(eUser);
		users.add(dUser);
		users.add(cUser);
		users.add(bUser);
		users.add(aUser);
		

		return users;
	}
}
