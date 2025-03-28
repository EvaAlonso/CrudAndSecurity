package com.discaCoders.crudsecurity.rest;

import com.discaCoders.crudsecurity.entity.Worker;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class WorkerController {

    List<Worker> workerList;

    @PostConstruct
    public void loadData() {

        workerList = new ArrayList<>();

        workerList.add( new Worker( 1, "Antonio", "Cabrera"));
        workerList.add( new Worker( 2, "Eva", "Alonso"));
        workerList.add( new Worker( 3, "Miller", "Montaña"));

    }
    @GetMapping("/workers")
    public List<Worker> allWorkers(){
        return workerList;
    }
    @GetMapping("/workers/{workerId}")
    public Worker getWorker(@PathVariable int workerId){
        for(Worker worker: this.workerList){
            if(worker.getId() == workerId){
                return worker;
            }
        }
        return null;
    }
    @PostMapping("/workers")
    public Worker addWorker(@RequestBody Worker theWorker){
        workerList.add(theWorker);
        return theWorker;
    }
    @PutMapping("/workers")
    public Worker updateWorker(@RequestBody Worker theWorker) {

        for(Worker worker: workerList) {

            if (worker.getId() == theWorker.getId()) {

                worker.setName(theWorker.getName());
                worker.setSurname(theWorker.getSurname());

            }

        }

        return theWorker;

    }

    @DeleteMapping("/workers/{workerId}")
    public String deleteWorker(@PathVariable int workerId) {

        this.workerList.removeIf(w -> w.getId() == workerId);

        return "Borrado trabajador/a con ID: " + workerId;

    }

}
