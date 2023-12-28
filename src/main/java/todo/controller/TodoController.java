package todo.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.protobuf.Service;

import todo.dto.TodoTask;
import todo.dto.TodoUser;
import todo.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	TodoService service;
	@GetMapping({"/","/login"})
	public String loadlogin() {
		return "Login";
	}
	@GetMapping("/signup")
	public String loadSignup() {
		return "Signup";
	}
	@GetMapping("/home")
	public String loadHome(HttpSession session, ModelMap model) {
		return service.loadHome(session,model);
	}
	@PostMapping("/signup")
	public String signup(TodoUser user,@RequestParam String date,ModelMap map) {
		return service.signup(user,date,map);
	}
	@PostMapping("/login")
	public String login(@RequestParam String email,@RequestParam String pass, ModelMap map,HttpSession session) {
		return service.login(email,pass, map,session);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap map) {
		session.invalidate();
		map.put("password","Logout Successfull");
		return "Login";
	}
	
	@GetMapping("/add-task")
	public String loadAddTask(HttpSession session, ModelMap map){
		return service.addTask(session,map);
	}
	
	@PostMapping("/add-task")
	public String addTask(TodoTask task,HttpSession session,ModelMap map) {
		return service.addTask(task,session,map);
	}
	
	@GetMapping("/change-status")
	public String changeStatus(@RequestParam int id,HttpSession session, ModelMap map) {
		return service.changeStatus(id, session, map);
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id,HttpSession session, ModelMap map) {
		return service.delete(id,session,map);
	}
	
	@GetMapping("/edit")
	public String loadEdit(HttpSession session,ModelMap map,@RequestParam int id)
	{
		return service.loadEdit(session,map,id);
	}

	@PostMapping("/update-task")
	public String updateTask(HttpSession session,ModelMap map,TodoTask task)
	{
		return service.updateTask(task,session,map);
	}
}
