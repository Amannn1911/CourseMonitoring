package dao;

import java.util.List;

import exception.BatchException;
import model.Batch;

public interface BatchDao {
    String addBatch(Batch batch) throws BatchException;

    Batch getBatchById(int batchId) throws BatchException;

    List<Batch> getAllBatches() throws BatchException;

    String allocateFacultyToBatch(int facultyId, int batchId) throws BatchException;

    String updateBatch(int batchId, Batch batch) throws BatchException;

    String deleteBatch(int batchId) throws BatchException;
}