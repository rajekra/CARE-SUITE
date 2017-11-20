package com.icare.dataprocessing.repository.intf;


public interface InpatientStagingRepoIntf {
public <T> T load(String tableName) throws Exception;
}
