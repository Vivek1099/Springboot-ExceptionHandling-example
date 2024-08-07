package Springboot_Exception_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeRepository erepo;

    @RequestMapping("/test")
    public String test()
    {
        return "This is exception test";
    }

    @RequestMapping("/save")
    public Employee save(@RequestBody Employee employee)
    {
        erepo.save(employee);
        return employee;
    }

    @RequestMapping("/all")
    public List<Employee> all()
    {
        return erepo.findAll();
    }

    @RequestMapping("/byid/{id}")
    public Optional<Employee> ById(@PathVariable int id) throws IdNotFoundException
    {
        Optional<Employee> employee = erepo.findById(id);
        if(employee.isEmpty())
        {
            throw new IdNotFoundException();
        }
        return employee;
    }

    @RequestMapping("/byname/{name}")
    public List<Employee> ByName(@PathVariable String name) throws NameNotFoundException
    {
        List<Employee> employee = erepo.findByName(name);
        if(employee.isEmpty())
        {
            throw new NameNotFoundException();
        }
        return employee;
    }

    @RequestMapping("/bycity/{city}")
    public List<Employee> ByCity(@PathVariable String city) throws CityNotFoundException
    {
        List<Employee> employee = erepo.findByCity(city);
        if(city==null)
        {
            throw new CityNotFoundException("City Not Found");
        }
        return employee;
    }

    @RequestMapping("del/{id}")
    public String del(@PathVariable int id)
    {
        erepo.deleteById(id);
        return "Deleted";
    }
    
    /*
     *  @RequestMapping("/{id}")
     *  public Employee hello(@PathVariale int id) throws IdNotFoundException
     *  {
     *  	Employee employee=erepo.findById(id).
     *  				orElseThrow{()->
     *  				new IdNotFoundException()};
     *  return employee;
     *  }
     * */
}
