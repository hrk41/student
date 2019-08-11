package com.hanlin.springboot.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.plaf.synth.SynthSpinnerUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanlin.springboot.pojo.Student;



@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	@RequestMapping("/list")
	public String list(Model model) {
		Student student = new Student();
		student.setSid(1);
		student.setSname("张三");;
		student.setSex("男");;
		student.setAge(18);;
		Student student2 = new Student();
		student2.setSid(2);
		student2.setSname("李四");;
		student2.setSex("女");;
		student2.setAge(19);;
		Student student3 = new Student();
		student3.setSid(3);
		student3.setSname("四");;
		student3.setSex("女");;
		student3.setAge(19);;
		List<Student> slist = new ArrayList<Student>();
		slist.add(student);
		slist.add(student2);
		slist.add(student3);
		
		System.out.println("ijajie"+slist);
		
		redisTemplate.opsForList().leftPushAll("student", slist);
		
		List<Object> range = redisTemplate.opsForList().range("student",0,-1);
		
		
		List<Student> ulist2 = null;
		for(Object object : range) {
			System.out.println(object);
			List<LinkedHashMap<Object,Object>> stu = (List<LinkedHashMap<Object,Object>>)object;
			/*JSONArray array = JSONArray.fromObject(stu);
			ulist2 = (List<Student>) JSONArray.toCollection(array, Student.class);
			System.out.println(ulist2);*/
			
			/*for (LinkedHashMap<Object,Object> map : stu) {
				
				
				
				Set<Entry<Object,Object>> entrySet = map.entrySet();
					for(Entry<Object,Object> m:entrySet) {
						System.out.println(m.getKey()+"="+m.getValue());
					}
			}*/
		}
		model.addAttribute("slist",ulist2);
		
		return "list";
	}
	
}
