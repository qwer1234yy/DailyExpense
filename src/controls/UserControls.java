package controls;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.ControlResponse;
import entities.User;

@Controller
@RequestMapping(value = "/user")
public class UserControls {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name = "name", defaultValue = "robbie", required = true) String username,
			@RequestParam(name = "pwd", defaultValue = "123456", required = true) String password) {
		System.out.println("login--------" + username + password);
		if ("user".equals(username) && "123456".equals(password)) {

			User aUser = new User();
			aUser.setNickname(username);
			aUser.setPassword(password);

			return "redirect:/user/login_ok.jsp";
		} else {
			return "forward:/user/login_fail.jsp";
			// return ControlResponse.createBySuccess(aUser);
		}

	}

	@RequestMapping(value = "/login2", method = RequestMethod.GET, params = { "username=admin", "role=admin",
			"password=123" })
	public ControlResponse<User> login_1() {
		System.out.println("login");

		User aUser = new User();
		return ControlResponse.createBySuccess("OK", aUser);
		// return ControlResponse.createBySuccess(aUser);
	}

	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ControlResponse<ArrayList<User>> get(
			@RequestParam(name = "name", defaultValue = "robbie", required = true) String username, String role,
			String password) {

		if (true) {
			ArrayList<User> users = new ArrayList<User>();
			User aUser = new User(001, "test@qq.com", "test01", "test111");
			User bUser = new User(002, "test@qq.com", "test02", "test111");
			User cUser = new User(003, "test@qq.com", "test03", "test111");
			User dUser = new User(004, "test@qq.com", "test04", "test111");
			users.add(aUser);
			users.add(bUser);
			users.add(cUser);
			users.add(dUser);
			return ControlResponse.createBySuccess("OK", users);
		}
		return null;
	}
}
