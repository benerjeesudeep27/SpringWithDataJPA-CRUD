package com.spring.datajpa.service;

import java.util.List;

import com.spring.datajpa.entity.Worker;

public interface WorkerService {
	public boolean insertAllWorkerDetails(List<Worker> list);
	public boolean updateWorkerDetails(Worker worker);
	public boolean deleteWorkerDetail(int id);
	public boolean deleteManyWorkers(List<Integer> list);
}
