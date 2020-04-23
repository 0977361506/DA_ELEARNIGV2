package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.Result;

public interface IResultService {
	public Result save(Result entity);
	public Result findbtId(Long id);
	public int countByidquestion(Long id,int count);
	 public void updateResultcheck(Long id,Long ans , String change , int code, int ma) ;
	 public List<Result> findAll(Long idq ,Long idr ) ;
	 public Result getResut(Long idq ,Long idr , String ans);
	 public int countByIdusserInresult(Long id) ;
	 public Result findbyIdUser(Long id);
	 public List<Result> findAllByCountest(Long idq ,Long idr ,int count,Long idu);
	 public List<Result> findLisResultstoShowForUser(Long idr ,int count,Long idu) ;
}
