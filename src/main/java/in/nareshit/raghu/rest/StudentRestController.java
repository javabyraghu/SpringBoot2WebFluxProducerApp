package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.model.Student;
import in.nareshit.raghu.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public Mono<Student> save(@RequestBody Student student) {
		return service.save(student);
	}
	
	@GetMapping("/all")
	public Flux<Student> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Mono<Student> getOne(@PathVariable Integer id) {
		 return service.getOne(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> remove(@PathVariable Integer id) {
		return service.delete(id);
	}
	
}
