package com.vnpost.e_learning.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vnpost.e_learning.bean.QuestionforRoundTest;
import com.vnpost.e_learning.bean.ResultBean;
import com.vnpost.e_learning.bean.ResultQuestion;
import com.vnpost.e_learning.entities.Answer;
import com.vnpost.e_learning.entities.Candidate;
import com.vnpost.e_learning.entities.Competition;
import com.vnpost.e_learning.entities.CompetitionCategory;
import com.vnpost.e_learning.entities.Question;
import com.vnpost.e_learning.entities.QuestionRoundTest;
import com.vnpost.e_learning.entities.Result;
import com.vnpost.e_learning.entities.RoundTest;
import com.vnpost.e_learning.entities.User;
import com.vnpost.e_learning.service.ICandidateService;
import com.vnpost.e_learning.service.ICompetitionService;
import com.vnpost.e_learning.service.IConpetitionCategoryService;
import com.vnpost.e_learning.service.IQuestionService;
import com.vnpost.e_learning.service.IResultService;
import com.vnpost.e_learning.service.IRoundTestService;
import com.vnpost.e_learning.service.IUserService;

import lombok.experimental.var;

@Controller
@RequestMapping("/competition")
public class CompetitionController {
    @Autowired
    IQuestionService q;
	@Autowired
	IUserService u;
	@Autowired
	ICandidateService can;
	@Autowired
	IResultService re;
	   @Autowired
	   IRoundTestService r;
	   @Autowired
	   ICompetitionService compe;
	   @Autowired
	   IConpetitionCategoryService cate;
	   public boolean checkidQuestion(HashSet<Long> kq , Long id) { // phuc vụ cho viecj checl id question cho show kq
		   int k = 0 ;
		   for(Long i : kq) {
			   if(i==id) k++ ;
			   
		   }
		   if(k>0) return true ;
		   return false ;
	   }
	   public List<String> changeListAnsserTolistString(List<Answer> list){
		   List<String> list2 = new ArrayList<String>();
		   for(Answer a : list) {
			   list2.add(a.getAnswer());
			   
		   }
		   return list2;
	   }
	   @RequestMapping("/show/result/{idu}/{idr}/{cou}")  // show result for user after go exam 
	   public String showResult(Model model,@PathVariable("idu") Long idu , @PathVariable("idr") Long idr , @PathVariable("cou") int sl ) {
		   
		   RoundTest roundTest = r.findByid(idr);
	       List<Result> results = re.findLisResultstoShowForUser(idr, sl, idu);
	       System.out.println(results.size());
	       HashSet<Long> kq = new HashSet<Long>();
	       
	       List<Result> chList = new ArrayList<Result>();
	       List<String> da = new ArrayList<String>();   
          
	       for(Result r: results) {
	    	   if(r.getAnswerCode()==1) {
	    		   kq.add(r.getQuestion().getId());
	    		   chList.add(re.findbtId(r.getId()));
	    	   }
	    	  
	       }
	       for(Result e: chList) {
	    	   da.add(e.getAnswer());
	       }
	       
	       
	       System.out.println("so luong phan tu là :"+ kq.size());
	       System.out.println("so luong phan tu của câu tra lo là là :"+da.size());
		  for(String a: da) {
			  System.out.println(a);
		  }
		   List<QuestionRoundTest> list = r.getListQuestionRountest(idr);
		
		   int i = 0 ;  
		   List<ResultBean> questions = new ArrayList<ResultBean>(); // list dap san cau tra loi cua user
		   for(QuestionRoundTest q : list) {
			   i++;
			   if(q.getQuestion().getStatusQuestion()==0 && checkidQuestion(kq,q.getQuestion().getId()) == true) {
			   questions.add(new ResultBean(i, q.getQuestion(), da,q.getQuestion().getTypeQuestion(),1));
			   }
			   else if(q.getQuestion().getStatusQuestion()==0 && checkidQuestion(kq,q.getQuestion().getId()) == false) {
				   questions.add(new ResultBean(i, q.getQuestion(), changeListAnsserTolistString(q.getQuestion().getAnswers()),q.getQuestion().getTypeQuestion(),0));
			   }
			   
		   }
		   
		 
		   model.addAttribute("obj", questions);

		
		   return "showResult";
		  
	   }
	   
	   @RequestMapping("/send/result/{idthisinh}/{idround}/{count}/{diem}/{socau}")
	   public String saveRessul(Model model ,@PathVariable("idthisinh") Long idu ,@PathVariable("idround") Long idr ,
			   @PathVariable("count") int sl ,@PathVariable("diem") int diem ,@PathVariable("socau") int socau) {
		   Candidate candidate = can.findbyIduAndUdrAndCount(idu, idr, sl);
		   RoundTest roundTest = r.findByid(idr);
		   candidate.setTimeend(new Date());
		   candidate.setPoint(socau);
		   candidate.setResult(diem);
		   
		   if(diem < roundTest.getMinPoint()) {
			   candidate.setStatus(1);
		   }
		   else   if(diem >= roundTest.getMinPoint()) {
			   candidate.setStatus(0);
		   }
		   can.save(candidate);
              Long aLong = (long) 5;
		   
		
		   if(roundTest.getDoAgain()==1) {
			   roundTest.setMaxWork(1);
			  r.save(roundTest);
		   }
		   List<Candidate> list = can.getListByIdUser(aLong, idr); // list candicate theo usser và id rounftest
		   int count = can.countByIdusser(aLong);
		   int check = checkusser(roundTest.getCandidates(), aLong);
		  if(roundTest!=null) model.addAttribute("round", roundTest);
		   model.addAttribute("count",count);
		  model.addAttribute("ma", idr);
		  model.addAttribute("check", check);
		  model.addAttribute("list", list);
		  model.addAttribute("dem",roundTest.getMaxWork());
		  model.addAttribute("socauz", roundTest.getQuestionRoundTests().size());
		   return "roundtest";
		   
	   }
	   
	   @RequestMapping("/home")
		 public String trangchuComppetition(Model model) {
			 List<Competition> competitions = compe.getListCompetitions();
			 List<CompetitionCategory> competitionCategories = cate.findAll();
			 model.addAttribute("listC", competitions);
			 model.addAttribute("listDC", competitionCategories);
			  return "competition";
			  
		  }
	   @RequestMapping("/roundtest/eror/{id}")
	   public String granMaxwork(Model model , @PathVariable("id") Long id) {
		   RoundTest roundTest = r.findByid(id);
		   model.addAttribute("loi", roundTest);
		   return "errorMaxwork";
	   }
	   
	   
	   @RequestMapping("/category/{id}")
	   public String getCompetitionFromCategory(Model model,@PathVariable("id") Long id) {
		  
				 List<Competition> competitions = compe.getListCompetitionsFromCategory(id);
				 List<CompetitionCategory> competitionCategories = cate.findAll();
				 model.addAttribute("listC", competitions);
				 model.addAttribute("listDC", competitionCategories);
				  return "competition";
				  
	   }
	   @RequestMapping("/listTest/index/{id}")
	   public String ShowListTest(Model model , @PathVariable("id") Long id) {
		
		   Competition competition = compe.findById(id);
		   List<RoundTest> roundTests = competition.getRoundTests();
		   model.addAttribute("list", roundTests);
		
		   return "ListCompetition";
	   }
	   
	   
	   @RequestMapping("/roundtest/{id}")
	   public String roundtesst(Model model ,@PathVariable("id") Long id) {
		   Long aLong = (long) 5;
		   
		   RoundTest roundTest = r.findByid(id);
		   if(roundTest.getDoAgain()==1) {
			   roundTest.setMaxWork(1);
			  r.save(roundTest);
		   }
		   List<Candidate> list = can.getListByIdUser(aLong, id); // list candicate theo usser và id rounftest
		   int count = can.countByIdusser(aLong);
		   int check = checkusser(roundTest.getCandidates(), aLong);
		  if(roundTest!=null) model.addAttribute("round", roundTest);
	//	  System.out.println(roundTest.getQuestionRoundTests().size());
		   model.addAttribute("count",count);
		  model.addAttribute("ma", id);
		  model.addAttribute("check", check);
		  model.addAttribute("list", list);
		  model.addAttribute("iduser",aLong);
		  model.addAttribute("dem",roundTest.getMaxWork());
		  model.addAttribute("socauz", roundTest.getQuestionRoundTests().size());
		  
		   return "roundtest";
	
	   }
	   
	   
	   @RequestMapping("/contentTest/{ma}")
	   public String contentTesst(Model model,@PathVariable("ma") Long id) {
		  Long iduser = (long) 5;
		   RoundTest roundTest = r.findByid(id);
	
		  
		   List<QuestionRoundTest> list = r.getListQuestionRountest(id);
		
		   int i = 0 ; 
		   List<QuestionforRoundTest> questions = new ArrayList<QuestionforRoundTest>();
		   for(QuestionRoundTest q : list) {
			   i++;
			   if(q.getQuestion().getStatusQuestion()==0) {
			   questions.add(new QuestionforRoundTest(i, q.getQuestion(), q.getQuestion().getAnswers(),q.getQuestion().getTypeQuestion()));
			   }
			   
		   }
		 
		   model.addAttribute("obj", questions);
		   model.addAttribute("count",questions.size());
		  model.addAttribute("round",roundTest);
		  model.addAttribute("ma", id);
		  model.addAttribute("iduser", iduser);
		   return "testcontent";
	   }
	   
	   
	   @RequestMapping("/contentTest/notUser")
	   public String notUsserInRoundTest() {
		   return "notUserinRoundTest";
	   }
	   
	   
	   
	   public int checkusser(List<Candidate> list ,Long id) {
	
		   for(Candidate c:list) {
			   if(c.getUser().getId()==id) {
				  return 1;
			   }
		   }
	
		   return 0;
	   }
	   
	   
//	   @ResponseBody
//	   @RequestMapping("/save/notDo/${idround}/${idthisinh")
//	   public void saveIfussernotDo(@PathVariable("idround") Long idr , @PathVariable("idthisinh") Long idu) {
//		    RoundTest roundTest = r.findByid(idr);
//		    List<QuestionRoundTest> list = r.getListQuestionRountest(idr);
//		    List<Question> questions = new ArrayList<Question>();
//		    List<Result> results = new ArrayList<Result>();
//		    for(QuestionRoundTest q :list) {
//		    	questions.add(q.getQuestion());
//		    }
//		    for(Question q: questions) {
//		    	
//		    	for(Result e: q.getResults()) {
//		    		results.add(e);
//		    	}
//		    }
//		    System.out.println(results.size());
//		    for(Result r: results) {
//		    	Result rw = new Result();
//		    	rw.setUser(u.findbyId(idu));
//		    	rw.setRoundTest(roundTest);
//		    	rw.set
//		    }
//		    
//	   }
	   
	   
	   
	   
	   
	   @ResponseBody
	   @RequestMapping("/roundtest/saveDateStart/{dateObj}/{idround}/{idthisinh}")
	   public int check(@PathVariable("dateObj") Date date , @PathVariable("idround") Long id ,@PathVariable("idthisinh") Long idu) {
		  
	     int count = can.countByIdusser(idu);
	     if(count==0) {
	    
	    	  Candidate result = can.findbyIdUser(idu);
			   result.setResult(0);
			   result.setTimestart(date);
			   result.setRoundTest(r.findByid(id));
			   result.setCounttest(count+1);
			   
			   result.setUser(u.findbyId(idu));
			  
			  can.save(result);
			//  System.out.println(result.getCounttest() + result.getUser().getEmail());
		 
	     }
	     else {
	    	
	    	  Candidate result = new Candidate();
				
			   result.setTimestart(date);
			   result.setRoundTest(r.findByid(id));
			   result.setCounttest(count+1);
			   result.setUser(u.findbyId(idu));
			  
			  can.save(result);
			//  System.out.println(result.getCounttest() + result.getUser().getEmail());
		
	     }
	     int dem = re.countByIdusserInresult(idu);
	     if(dem==0) {
	    
	    	 Result result = new Result();
				
			
			   result.setRoundTest(r.findByid(id));
			   result.setCounttest(count+1);
			   
			   result.setUser(u.findbyId(idu));
			  
			  re.save(result);
			//  System.out.println(result.getCounttest() + result.getUser().getEmail());
		    return result.getCounttest();
	     }
	     else {
	    	
	    	  Result result = new Result();
				
			
			   result.setRoundTest(r.findByid(id));
			   result.setCounttest(count+1);
			   result.setUser(u.findbyId(idu));
			  
			  re.save(result); 
			  
			  return result.getCounttest();	//  System.out.println(result.getCounttest() + result.getUser().getEmail());
		    
	     }
	     
	     
		  
	   }

	   @ResponseBody
	   @RequestMapping("/save/result") // xử lí nop bài
	   public Object[]  giveandSaveTest(@RequestBody ResultQuestion resultQuestion) {
		   int mm =0; int diem =0; int kk = 0; int point = 0 ; 
		//   int count = re.countByIdusserInresult(resultQuestion.getIduser());
		   Question question = q.findbyId(resultQuestion.getIdquestion());// lấy ra cau hoi
		   List<Answer> answers = question.getAnswers(); // lấy ra đáp án;
		  int count = 0 ;
		 
		List<Candidate> candidates = can.OrderByCandicateByCountest(resultQuestion.getIduser(), resultQuestion.getIdRoundtest());
		  if(candidates.size()== 0) {
			  count = 0 ;
		  }else {
			count = candidates.get(0).getCounttest();
		}
		//  System.out.println("so luong bay gio la :" + count);
		  int sl = re.countByidquestion(resultQuestion.getIdquestion(),count+1);
		//  System.out.println("so luon ghien tai la " + sl);
		if(count==0) {  // truong hop lam lan dau tien
			   if(sl==0) {
			    	for(String s : resultQuestion.getCheck() ) {
				    	Result result = new Result();
				    	result.setAnswer(s);
				    	 result.setUser(u.findbyId(resultQuestion.getIduser()));
				    	result.setTimeStart(new Date());
				    	result.setQuestion(q.findbyId(resultQuestion.getIdquestion()));
				    	result.setRoundTest(r.findByid(resultQuestion.getIdRoundtest()));
				    	result.setAnswerCode(1);
				    	result.setCounttest(count+1);
				    	re.save(result);
			
				    }
				    
				    for(String s : resultQuestion.getNocheck() ) {
				    	Result result = new Result();
				    	result.setAnswer(s);
				    	 result.setUser(u.findbyId(resultQuestion.getIduser()));
				    	 result.setTimeStart(new Date());
				    	result.setQuestion(q.findbyId(resultQuestion.getIdquestion()));
				    	result.setRoundTest(r.findByid(resultQuestion.getIdRoundtest()));
				    	result.setAnswerCode(0);
				    	result.setCounttest(count+1);
			
				    	re.save(result);
				 
				    }
			    }
			    else {// tiên hanh câp nhât đáp án]
			    	List<Result> list = re.findAll(resultQuestion.getIdquestion(), resultQuestion.getIdRoundtest());
			   if(resultQuestion.getCheck().size()>0) {
				 	
			    	for(String s : resultQuestion.getCheck() ) {
				       for(Result r: list) {
				    	  if(r.getAnswer().equals(s) && r.getQuestion().getId()==resultQuestion.getIdquestion() && r.getRoundTest().getId()==resultQuestion.getIdRoundtest()&& r.getUser().getId()== resultQuestion.getIduser()) {
				    		  r.setAnswer(s);
				    		  r.setTimeStart(new Date());
				    		  r.setAnswerCode(1);
				    		  
				    		  re.save(r);
				    	
				    	  }
				       }
				    }
			    	
				
			   }
			   if(resultQuestion.getNocheck().size()>0) {
				    
				    for(String s : resultQuestion.getNocheck() ) {
				    	for(Result r: list) {
					    	  if(r.getAnswer().equals(s) && r.getQuestion().getId()==resultQuestion.getIdquestion() && r.getRoundTest().getId()==resultQuestion.getIdRoundtest()&& r.getUser().getId()== resultQuestion.getIduser()) {
					    		  r.setAnswer(s);
					    		  r.setTimeStart(new Date());
					    		  r.setAnswerCode(0);
					    		 
					    		  re.save(r);
					    	  }
					       }
				    }
			   }
			 }
			   
			
			 
			   
		   }else { // làm lần tiếp theo
			   if(sl==0) {
			    	for(String s : resultQuestion.getCheck() ) {
				    	Result result = new Result();
				    	result.setAnswer(s);
				    	 result.setUser(u.findbyId(resultQuestion.getIduser()));
				    	result.setTimeStart(new Date());
				    	result.setQuestion(q.findbyId(resultQuestion.getIdquestion()));
				    	result.setRoundTest(r.findByid(resultQuestion.getIdRoundtest()));
				    	result.setAnswerCode(1);
				    	result.setCounttest(count+1);
				    	re.save(result);
				    	System.out.println(result.getAnswerCode());
				   
				    }
				    
				    for(String s : resultQuestion.getNocheck() ) {
				    	Result result = new Result();
				    	result.setAnswer(s);
				    	 result.setUser(u.findbyId(resultQuestion.getIduser()));
				    	 result.setTimeStart(new Date());
				    	result.setQuestion(q.findbyId(resultQuestion.getIdquestion()));
				    	result.setRoundTest(r.findByid(resultQuestion.getIdRoundtest()));
				    	result.setAnswerCode(0);
				    
				    	result.setCounttest(count+1);
				    	re.save(result);
				    }
			    }
			    else  {
			    	List<Result> list = re.findAll(resultQuestion.getIdquestion(), resultQuestion.getIdRoundtest());
			    
			   if(resultQuestion.getCheck().size()>0) {
				 	
			    	for(String s : resultQuestion.getCheck() ) {
				       for(Result r: list) {
				    	  if(r.getAnswer().equals(s) && r.getQuestion().getId()==resultQuestion.getIdquestion() && r.getRoundTest().getId()==resultQuestion.getIdRoundtest()&& r.getUser().getId()== resultQuestion.getIduser()) {
				    		  r.setAnswer(s);
				    		  r.setTimeStart(new Date());
				    		  r.setAnswerCode(1);
				    		  //r.setCounttest(resultQuestion.getCount());
				    		  re.save(r);
				    
				    	  }
				       }
				    }
				
			   }
			   if(resultQuestion.getNocheck().size()>0) {
				    
				    for(String s : resultQuestion.getNocheck() ) {
				    	for(Result r: list) {
					    	  if(r.getAnswer().equals(s) && r.getQuestion().getId()==resultQuestion.getIdquestion() && r.getRoundTest().getId()==resultQuestion.getIdRoundtest()&& r.getUser().getId()== resultQuestion.getIduser()) {
					    		  r.setAnswer(s);
					    		  r.setTimeStart(new Date());
					    		  r.setAnswerCode(0);
					    		  
					    	//	  r.setCounttest(resultQuestion.getCount());
					    		  re.save(r);
					    	  }
					       }
				    }
			   }
			 }
			   
			   Question question2 =  q.findbyId(resultQuestion.getIdquestion());
				 RoundTest roundTest = r.findByid(resultQuestion.getIdRoundtest());
			 List<Result> liqList = re.findAllByCountest(resultQuestion.getIdquestion(), resultQuestion.getIdRoundtest(), resultQuestion.getCount()+1,resultQuestion.getIduser());
			 for(Result a: liqList) {
				 
				if(checkin(answers, a.getAnswer(), a.getAnswerCode())== true) mm++;
			 }
			 if(mm==answers.size()) {
				
				 
				diem++;
				point = question2.getLevell().getAddPoints().get(0).getAddPoint();				// System.out.println("ban ddax tra loi dung cau thu "+resultQuestion.getIdquestion());
			 }else {
				 point = -(question2.getLevell().getSubPoints().get(0).getSub());
			 }
		
			
			// System.out.println("diem cua ban la"+diem);
		   }
		   Object[] pObjects = {diem,point}; 
		 return pObjects;
	   }
	   
	   public boolean checkin(List<Answer> list, String a , int b) {
		   int k = 0 ;
		   for(Answer m:list) {
			   if(m.getAnswer().equals(a)&& m.getAnswerCode()==b) k++;
			   
		   }
		   if(k>0) return true;
		   return false;
	   }
}
