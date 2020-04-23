package com.vnpost.e_learning.service.impl;


import com.vnpost.e_learning.bean.CourseConfigWare;
import com.vnpost.e_learning.converter.CourseConverter;
import com.vnpost.e_learning.dto.CourseDTO;
import com.vnpost.e_learning.entities.Course;
import com.vnpost.e_learning.entities.New;
import com.vnpost.e_learning.entities.Outline;
import com.vnpost.e_learning.entities.Rate;
import com.vnpost.e_learning.repository.CourseRepository;
import com.vnpost.e_learning.service.ICourseService;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseConverter converter;
    @Autowired
    EntityManagerFactory en;
   @Autowired
   EntityManager enti;

    @Override
    public Course findById(Long id) {
    	Session session = en.createEntityManager().unwrap(Session.class);
    	Course aNew = session.find(Course.class, id);
    	return aNew;
    }
    public List<Course> findbyDetailCategory(Long id){ // láy ra tất cả khóa học của từng chueyen mục
    	Session session = en.createEntityManager().unwrap(Session.class);
       String hql = "from Course c where c.coursecategory.id=:cid";
       Query query = session.createQuery(hql);
       query.setParameter("cid", id);
       List<Course> list = query.getResultList();
       return list ;
    }
    
    public List<Course> findbyCategory(Long id ,Long id2){ // lấy ra tất cả các khóa học liên quan
    	Session session = en.createEntityManager().unwrap(Session.class);
       String hql = "from Course c where c.coursecategory.id=:cid and c.id!=:vid";
       Query query = session.createQuery(hql);
       query.setParameter("cid", id);
       query.setParameter("vid", id2);
       List<Course> list = query.getResultList();
       return list ;
    }
    public List<Course> findbyhightlight(){
    	Session session = en.createEntityManager().unwrap(Session.class);
       String hql = "from Course c where c.highlight=1";
       Query query = session.createQuery(hql);
       List<Course> list = query.getResultList();
       return list ;
    }
    @Override
    public List<Course> findAlls() {
    	
    	  String hql = "from Course c where c.status=1";
    	   List<Course> courses = enti.unwrap(Session.class).createQuery(hql).getResultList();
    	       return courses ;
    }

	@Override
    
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream()
                .map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    public  List<Course> findAlls(Example<Course> example) {
		return courseRepository.findAll(example);
	}
   


	@Override
    public CourseDTO findById(long id) {
        return converter.convertToDTO(courseRepository.findById(id));
    }

    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        if (courseDTO.getId()==null){
            Course course = converter.convertToEntity(courseDTO);
            return converter.convertToDTO(courseRepository.save(course));
        }
        return new CourseDTO();
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        if (courseDTO.getId()!=null){
            Course course = converter.convertToEntity(courseDTO);
            Course courseInDb = courseRepository.findById(course.getId()).get();
            course.setCreatedDate(courseInDb.getCreatedDate());
            course.setCreatedBy(courseInDb.getCreatedBy());
            return converter.convertToDTO(courseRepository.save(course));
        }
        return new CourseDTO();
    }
    public List<Course> findByKeyWord(String key){
    	Session session = en.createEntityManager().unwrap(Session.class);
    	String hqString = "from Course c where c.name like :cid ";
    	Query query = session.createQuery(hqString);
    	query.setParameter("cid","%"+key+"%");
    	List<Course> list = query.getResultList();
    	return list;
    }

    public List<String> getTenHocLieeuForCourse(){ // lay ra list tenhoclieu
    	String hqString = "select kkk.tenhoclieu from (select * from \r\n" + 
    			"     (select xx.id as maChapandOut , xx.name , xx.id_outline , xx.maCuocThi , xx.maChuongMuc, xx.tenChuongMuc\r\n" + 
    			"     from  ( select * from  chapter as chap  ,\r\n" + 
    			"	 (SELECT c.id as maCuocThi, o.id  as maChuongMuc, o.name as tenChuongMuc  , o.id_course FROM course as c ,outline as o where c.id= o.id_course) as x\r\n" + 
    			"	  where x.maChuongMuc = chap.id_outline) as xx) as xxx ,\r\n" + 
    			"\r\n" + 
    			"	  chapter_course_ware as yyy\r\n" + 
    			"\r\n" + 
    			"    , (select hoclieu.id as mahoclieu , hoclieu.name as tenhoclieu , loaihoclieu.id as maloaihoclieu , loaihoclieu.name as tenloaihochieu\r\n" + 
    			"    from course_ware as hoclieu , course_ware_type as loaihoclieu\r\n" + 
    			"    where hoclieu.id_course_ware_type = loaihoclieu.id) as zzz\r\n" + 
    			"	  \r\n" + 
    			"	   where xxx.maChapandOut=yyy.id_chapter \r\n" + 
    			"	   and yyy.id_course_ware = zzz.mahoclieu) as kkk;";
    	Session session = en.createEntityManager().unwrap(Session.class);
    	SQLQuery query = session.createSQLQuery(hqString);
    	List<String> list = query.getResultList();
    	return list ;
    	
    }
    
    public List<CourseConfigWare> getCourseConfigWares(){ // tim ten các loại học liêu
    	String hqString = "	select kkk.maCuocThi as idCourse , kkk.tenhoclieu as nameCourseWare, kkk.tenloaihochieu as nameTypeCoureWare, kkk.name as nameCategory,\r\n" + 
    			"	kkk.maloaihoclieu as idTypeCourseWare , kkk.mahoclieu as idCourseWare\r\n" + 
    			"	from (select * from \r\n" + 
    			"     (select xx.id as maChapandOut , xx.name , xx.id_outline , xx.maCuocThi , xx.maChuongMuc, xx.tenChuongMuc\r\n" + 
    			"     from  ( select * from  chapter as chap  ,\r\n" + 
    			"	 (SELECT c.id as maCuocThi, o.id  as maChuongMuc, o.name as tenChuongMuc  , o.id_course FROM course as c ,outline as o where c.id= o.id_course) as x\r\n" + 
    			"	  where x.maChuongMuc = chap.id_outline) as xx) as xxx ,\r\n" + 
    			"\r\n" + 
    			"	  chapter_course_ware as yyy\r\n" + 
    			"\r\n" + 
    			"    , (select hoclieu.id as mahoclieu , hoclieu.name as tenhoclieu , loaihoclieu.id as maloaihoclieu , loaihoclieu.name as tenloaihochieu\r\n" + 
    			"    from course_ware as hoclieu , course_ware_type as loaihoclieu\r\n" + 
    			"    where hoclieu.id_course_ware_type = loaihoclieu.id) as zzz\r\n" + 
    			"	  \r\n" + 
    			"	   where xxx.maChapandOut=yyy.id_chapter \r\n" + 
    			"	   and yyy.id_course_ware = zzz.mahoclieu) as kkk;";
    	Session session = en.createEntityManager().unwrap(Session.class);
    	NativeQuery query = session.createNativeQuery(hqString); 
    	
    	List<CourseConfigWare> list = query.setResultTransformer( Transformers.aliasToBean(CourseConfigWare.class ) ).list();
    	return list ;
    	
    }
    

}
