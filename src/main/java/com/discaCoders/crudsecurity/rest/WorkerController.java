package com.discaCoders.crudsecurity.rest;

import com.discaCoders.crudsecurity.entity.Worker;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
