package com.spring.datajpa.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.datajpa.entity.Worker;
import com.spring.datajpa.resources.SpringConfigFile;
import com.spring.datajpa.service.WorkerService;

public class AppTesting {

	public static void main(String[] args) {
		Worker work = new Worker();
		work.setId(5);
		work.setName("Neha");
		work.setCity("Chennai");
		work.setProject("Music");
		work.setSalary(30000.0f);
		Worker work1 = new Worker();
		work1.setName("Kuber");
		work1.setCity("Noida");
		work1.setProject("Highways");
		work1.setSalary(60000.0f);
		Worker work2 = new Worker();
		work2.setName("Kartik");
		work2.setCity("Delhi");
		work2.setProject("Waters");
		work2.setSalary(50000.0f);
		Worker work3 = new Worker();
		work3.setName("Mukesh");
		work3.setCity("Kanpur");
		work3.setProject("Railways");
		work3.setSalary(80000.0f);
		List<Worker> list = new ArrayList<Worker>();
		list.add(work);
		list.add(work1);
		list.add(work2);
		list.add(work3);
	
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		WorkerService workerService = (WorkerService) context.getBean("workerServiceImpl");
		List<Integer>list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(6);
		list1.add(7);
//		workerService.deleteManyWorkers(list1);
		workerService.insertAllWorkerDetails(list);
	}

}
