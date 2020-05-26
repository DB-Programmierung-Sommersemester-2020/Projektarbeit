package bookshop.repositories.implementations;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import bookshop.repositories.services.CRUDRepositoryService;

public abstract class CRUDRepository<T, ID extends Serializable> implements CRUDRepositoryService<T, ID> {

	private final String persistenceUnit = "Bookshop";
	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public CRUDRepository() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected Class<T> getEntityClass() {
		return entityClass;
	}

	@Override
	public Set<T> getAll() {
		String query = "Select t from " + entityClass.getSimpleName() + " t";
		Set<T> entities = new HashSet<T>();
		EntityManager em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();

		em.getTransaction().begin();

		TypedQuery<T> result = em.createQuery(query, getEntityClass());
		entities = result.getResultStream().collect(Collectors.toSet());

		em.getTransaction().commit();
		em.close();

		return entities;
	}

	@SuppressWarnings("deprecation") //Used jdk 11.0.7 LTS instead of 1.8.*
	@Override
	public T getByKey(ID id) {
		T entity = null;
		try {
			entity = getEntityClass().newInstance();
			EntityManager em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();

			em.getTransaction().begin();

			entity = em.find(entityClass, id);

			em.getTransaction().commit();
			em.close();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return entity;
	}

	@Override
	public boolean create(T entity) {
		boolean isCreated = false;

		EntityManager em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();

		isCreated = this.getAll().contains(entity);

		return isCreated;
	}

	@Override
	public boolean update(T entity) {
		boolean isUpdated = false;

		EntityManager em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();

		isUpdated = (this.getAll().contains(entity)) ? true : false;

		return isUpdated;
	}

	@Override
	public boolean delete(T entity) {
		boolean isDeleted = false;

		EntityManager em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
		em.close();

		isDeleted = (this.getAll().contains(entity)) ? false : true;

		return isDeleted;
	}
}