package service;

import java.util.List;

import dao.BatchDao;
import dao.BatchDaoImpl;
import exception.BatchException;
import model.Batch;

public class BatchServiceImpl implements BatchService{
    private BatchDao dao;

    public BatchServiceImpl() {
        this.dao = new BatchDaoImpl();
    }

    public String addBatch(Batch batch) {
        return dao.addBatch(batch);
    }

    public Batch getBatchById(int batchId) {
        return dao.getBatchById(batchId);
    }

    public List<Batch> getAllBatches() {
        return dao.getAllBatches();
    }

    public String allocateFacultyToBatch(int facultyId, int batchId) throws BatchException {
        return dao.allocateFacultyToBatch(facultyId,batchId);
    }


    public String updateBatch(int batchId, Batch batch) throws BatchException {
        return dao.updateBatch(batchId,batch);
    }

    public String deleteBatch(int batchId) throws BatchException {
        return dao.deleteBatch(batchId);
    }
}