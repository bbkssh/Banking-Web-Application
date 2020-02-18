package Banking.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Discover")
public class Controller {

    @Autowired
    Service service;

    @PostMapping("/deposit")
    public int add(@RequestBody DTO depositItems) {
        service.arrayList.add(depositItems.getAmount());
        return service.arrayList.stream().mapToInt(a -> a).sum();
    }

    @GetMapping("/deposit/{depositNumber}")
    public int deposit(@PathVariable("depositNumber") int depositNumber) {
        return service.arrayList.get(depositNumber - 1);
    }

    @GetMapping("/history")
    public List history(){
        return service.arrayList;
    }

    @DeleteMapping("/remove/{value}")
    public List remove(@PathVariable("value") int value){
        service.arrayList.set((value - 1),0);
        return service.arrayList;
    }

}
