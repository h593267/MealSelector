package no.arnemunthekaas.DB.DAO;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.arnemunthekaas.DB.entity.Meal;
import no.arnemunthekaas.DB.entity.Mealrelations;

@Stateless
public class MealrelationsDAO {
	
	public static MealrelationsDAO mealrelationsDAO;

	@PersistenceContext(name = "mealDB")
	private EntityManager em;

	public List<Mealrelations> getAll() {
		List<Mealrelations> allrelations = em.createQuery("select m from Mealrelations m", Mealrelations.class).getResultList();
		return allrelations;
	}
	
	public List<String> getAllUniqueCuisineNamesUsed() {
		List<Mealrelations> allrelations = getAll();
		return allrelations.stream().map(o -> o.getCuisine().getName()).distinct().collect(Collectors.toList());
	}
	
	public void addRelation(Mealrelations mealrelations) {
		em.persist(mealrelations);
	}
	
	public Mealrelations find(Meal meal) {
		return find(meal.getID());
	}

	public Mealrelations find(int ID) {
		for(Mealrelations x : getAll()) {
			if(x.getMeal().getID() == ID)
				return x;
		}
		return null;
	}
}
