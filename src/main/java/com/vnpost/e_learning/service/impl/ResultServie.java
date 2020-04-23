
package com.vnpost.e_learning.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.criteria.LiteralHandlingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnpost.e_learning.entities.Candidate;
import com.vnpost.e_learning.entities.Result;
import com.vnpost.e_learning.repository.ResultRepository;
import com.vnpost.e_learning.service.IResultService;
@Service
public class ResultServie implements IResultService{
@Autowired
ResultRepository repository ;
@Autowired

@PersistenceContext
EntityManager entityManager ;

public List<Result> findLisResultstoShowForUser(Long idr ,int count,Long idu) {
	  String hqString = "from Result r where r.roundTest.id=:idr and r.counttest=:cou and r.user.id=:idu and r.question <> NULL ";
		 List<Result> list = entityManager.unwrap(Session.class).createQuery(hqString).
				  setParameter("idr", idr) .setParameter("cou",count).setParameter("idu", idu).getResultList();
		 return list;
}
public Result save(Result entity) {
	return repository.save(entity);
}
  public Result findbtId(Long id) {
	  return entityManager.unwrap(Session.class).find(Result.class, id);
  }
  public int countByidquestion(Long id,int count) {
	  String hqlString = "from Result r where r.question.id=:cid and r.counttest=:cou";
	
	  List<Result> list = entityManager.unwrap(Session.class).createQuery(hqlString).setParameter("cid", id)
			  .setParameter("cou", count).getResultList();
	  return list.size();
  }
  
  public Result getResut(Long idq ,Long idr , String ans) {
	  String hqString = "from Result r where r.question.id=:idq and r.roundTest.id=:idr and r.answer=:ans";
	 List<Result> list = entityManager.unwrap(Session.class).createQuery(hqString).setParameter("idq", idq).
			  setParameter("idr", idr) .setParameter("ans", ans).getResultList();
	 return list.get(0);
			  }
  
  
  public List<Result> findAll(Long idq ,Long idr ) {
	  String hqString = "from Result r where r.question.id=:idq and r.roundTest.id=:idr ";
		 List<Result> list = entityManager.unwrap(Session.class).createQuery(hqString).setParameter("idq", idq).
				  setParameter("idr", idr) .getResultList();
		 return list;
}
  
  public List<Result> findAllByCountest(Long idq ,Long idr ,int count,Long idu) {
	  String hqString = "from Result r where r.question.id=:idq and r.roundTest.id=:idr and r.counttest=:cou and r.user.id=:idu";
		 List<Result> list = entityManager.unwrap(Session.class).createQuery(hqString).setParameter("idq", idq).
				  setParameter("idr", idr) .setParameter("cou",count).setParameter("idu", idu).getResultList();
		 return list;
}
public void updateResultcheck(Long id,Long ans , String change , int code ,int ma) {
	 
		StoredProcedureQuery query = entityManager
			    .createStoredProcedureQuery("updates")
			    .registerStoredProcedureParameter(
			        "id", Long.class, ParameterMode.IN)

			    .setParameter("id", id)
			    .registerStoredProcedureParameter(
				        "code", Integer.class, ParameterMode.IN)

				    .setParameter("code", code)
				    .registerStoredProcedureParameter(
					        "idr", Long.class, ParameterMode.IN)

					    .setParameter("idr", ans)
					    .registerStoredProcedureParameter(
						        "string", String.class, ParameterMode.IN)

						    .setParameter("string", change)
						    .registerStoredProcedureParameter(
							        "ma", Integer.class, ParameterMode.IN)

							    .setParameter("ma", ma);
;

			query.execute();
	
    
  }
public int countByIdusserInresult(Long id) {
	int k = 0 ; int m = 0;
	String hqlString = "from Result c where c.user.id=:cid";
	List<Result> list = entityManager.unwrap(Session.class).createQuery(hqlString).setParameter("cid",id).getResultList();
	for(Result c: list) {
	     if(c.getCounttest() == 0) k++;
	     else {
	    	 m++;
	     }
	}
     
	if(k==1) return 0;
	if(m!=0) return m;
	return 0;

}
public Result findbyIdUser(Long id) {
	String hqlString = "from Result c where c.user.id=:cid and c.counttest=0";
	List<Result> list = entityManager.unwrap(Session.class).createQuery(hqlString).setParameter("cid",id).getResultList();

		Result candidate = list.get(0);
		return candidate;	

}
}
