package in.nareshit.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.model.Student;
import in.nareshit.raghu.repo.StudentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Mono<Student> save(Student std) {
		return repo.save(std);
	}
	
	public Mono<Student> getOne(Integer id){
		return repo.findById(id);
	}
	
	public Flux<Student> findAll(){
		return repo.findAll();
	}
	
	public Mono<Void> delete(Integer id){
		return repo.deleteById(id);
	}
	
}
