package todo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import todo.dto.*;

@Component
public class TodoDao {
	@Autowired
	EntityManager manager;

	public void saveUser(TodoUser dto) {
		manager.getTransaction().begin();
		manager.persist(dto);
		manager.getTransaction().commit();
	}

	public List<TodoUser> fingByEmail(String email) {
		return manager.createQuery("select x from TodoUser x where email=?1").setParameter(1, email).getResultList();

	}

	public void saveTask(TodoTask task) {
		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();
	}

	public List<TodoTask> fetchAllTask(int id) {
		return manager.createQuery("select x from TodoTask x where user_id=?1").setParameter(1, id).getResultList();
	}
	
	public TodoTask fetchTaskById(int id) {
		return manager.find(TodoTask.class, id);
	}

	public void update(TodoTask task) {
		manager.getTransaction().begin();
		manager.merge(task);
		manager.getTransaction().commit();
		
	}
	public void delete(TodoTask task) {
		manager.getTransaction().begin();
		manager.remove(task);
		manager.getTransaction().commit();
	}

}
