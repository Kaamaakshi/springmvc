package spring.mvc.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.practice.DAO.StudentDao;
import spring.mvc.practice.DTO.StudentDto;

@Controller
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@ResponseBody
	@RequestMapping("/insert")
	public String insert(@ModelAttribute StudentDto studentDto) {
		studentDao.insert(studentDto);
		return "data inserted";
	}

	@RequestMapping("/fid{id}")
	public ModelAndView fid(@RequestParam int id) {
		StudentDto dto = studentDao.fid(id);
		ModelAndView modelAndView = new ModelAndView("fid.jsp");
		modelAndView.addObject("data", dto);
		return modelAndView;
	}

	@RequestMapping("/fetchall")
	public ModelAndView fall() {
		List<StudentDto> l = studentDao.fall();
		ModelAndView modelAndView = new ModelAndView("fall.jsp");
		modelAndView.addObject("data", l);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("did{id}")
	public String did(@RequestParam int id) {
		return studentDao.did(id);

	}

	@ResponseBody
	@RequestMapping("/dall")
	public String dall() {
		String msg = studentDao.dall();
		return msg;
	}

	@ResponseBody
	@RequestMapping("/update")
	public String modify(StudentDto studentDto) {
		String msg = studentDao.modify(studentDto);
		return msg;

	}

}
