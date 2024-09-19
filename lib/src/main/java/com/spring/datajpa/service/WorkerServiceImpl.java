package com.spring.datajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.datajpa.entity.Worker;
import com.spring.datajpa.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {
	@Autowired
	private WorkerRepository workerRepository;

	@Transactional
	@Override
	public boolean insertAllWorkerDetails(List<Worker> list) {
		boolean flag = false;
		try {
			workerRepository.saveAll(list);
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Transactional
	@Override
	public boolean updateWorkerDetails(Worker worker) {
		boolean flag = false;
		try {
			workerRepository.save(worker);
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Transactional
	@Override
	public boolean deleteWorkerDetail(int id) {
		boolean flag = false;
		try {
			workerRepository.deleteById(id);
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Transactional
	@Override
	public boolean deleteManyWorkers(List<Integer> list) {
		boolean flag = false;
		try {
			workerRepository.deleteAllByIdInBatch(list);
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

}
