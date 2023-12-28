package todo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import todo.dao.TodoDao;
import todo.dto.TodoTask;
import todo.dto.TodoUser;
import todo.helper.AES;
@Component
public class TodoService {
	@Autowired
	TodoDao dao;
	
	public String signup(TodoUser user,String date, ModelMap map) {
		 user.setDob(LocalDate.parse(date));
		 user.setAge(Period.between(user.getDob(), LocalDate.now()).getYears());
		 user.setPass(AES.encrypt(user.getPass(), "123"));
		 if(user.getAge()<18) {
			 map.put("msg", "You Have to be 18 and above to Create Account");
			 return "Signup";
		 }else {
			 List<TodoUser> list=dao.fingByEmail(user.getEmail());
			 if(list.isEmpty()) {
				 dao.saveUser(user);
				 map.put("pass", "Created Successfuly");
				 return "Login";
			 }else {
				 map.put("email", "Email should be Unique");
				 return "Login";
			 }
			
		 }
	}
	
	public String login(String email,String password, ModelMap map,HttpSession session) {
		List<TodoUser> list=dao.fingByEmail(email);
		if(list.isEmpty()) {
			map.put("email", "incorrect Email");
			return "Login";
		}else {
			if(password.equals(AES.decrypt(list.get(0).getPass(),"123"))) {
				session.setAttribute("todouser",list.get(0));
				map.put("list", dao.fetchAllTask(list.get(0).getId()));
				map.put("password", "Login Success");
				return "Home";
			}else {
				map.put("pass", "Incorrect Password");
				return "Login";
			}
		}
          
	}
	public String loadHome(HttpSession session, ModelMap map) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Login";
		} else {
			map.put("list", dao.fetchAllTask(user.getId()));
			return "Home";
		}
	}

	public String addTask(HttpSession session, ModelMap map) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Login";
		} else {
			return "AddTask";
		}
	}
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.put("pass", "Logout Success");
		return "Login";
	}

	public String addTask(TodoTask task, HttpSession session, ModelMap map) {
		TodoUser user=(TodoUser) session.getAttribute("todouser");
		if(user==null) {
			map.put("fail", "Invaild Session");
			return "Login";
		}else {
			task.setCreatedTime(LocalDateTime.now());
			task.setUser(user);
			dao.saveTask(task);
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Data Saved Successfully");
			return "Home";
		}
	}
	
	public String changeStatus(int id,HttpSession session, ModelMap map) {
		TodoUser user=(TodoUser)session.getAttribute("todouser");
		if(user==null) {
			map.put("fail", "Invalid session");
			return "Login";
		}else{
			TodoTask task=dao.fetchTaskById(id);
			task.setStatus(true);
			dao.update(task);
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Status Changed Success");
			return "Home";
		}
	}

	public String delete(int id, HttpSession session, ModelMap map) {
		TodoUser user=(TodoUser)session.getAttribute("todouser");
		if(user==null) {
			map.put("fail","Inavild Session");
			return "Login";
		}else {
			TodoTask task=dao.fetchTaskById(id);
			dao.delete(task);
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Task Deleted Success");
			return "Home";
		}
	}

	public String loadEdit(HttpSession session, ModelMap map, int id) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Login";
		} else {
			TodoTask task = dao.fetchTaskById(id);
			map.put("task", task);
			return "EditTask";
		}
}

	public String updateTask(TodoTask task, HttpSession session, ModelMap map) {
		TodoUser user=(TodoUser) session.getAttribute("todouser");
		if(user==null) {
			map.put("fail", "Inavail Session");
			return "Login";
		}else {
			task.setUser(user);
			task.setCreatedTime(LocalDateTime.now());
			dao.update(task);
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Task Updated Success");
			return "Home";
			
		}
}
}
