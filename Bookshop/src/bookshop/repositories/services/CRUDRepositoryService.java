package bookshop.repositories.services;

import java.util.Set;

public interface CRUDRepositoryService <T, ID>{
	Set<T> getAll();
	T getByKey(ID id);
	boolean create(T entity);
	boolean update(T entity);
	boolean delete(T entity);
}
