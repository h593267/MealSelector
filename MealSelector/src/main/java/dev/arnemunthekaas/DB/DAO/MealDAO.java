package dev.arnemunthekaas.DB.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.arnemunthekaas.DB.entity.Meal;

@Stateless
public class MealDAO {
	
	@PersistenceContext(name = "mealDB")
	private EntityManager em;

	public List<Meal> getAll() {
		List<Meal> allmeals = em.createQuery("select m from Meal m", Meal.class).getResultList();
		return allmeals;
	}
	
	public void addMeal(Meal meal) {
		em.persist(meal);
	}
	
	public Meal find(Integer ID) {
		try {
			return em.find(Meal.class, ID);
		} catch (Exception e) {
			return null;
		}	
	}

}