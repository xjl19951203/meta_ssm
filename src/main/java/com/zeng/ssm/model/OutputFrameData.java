package com.zeng.ssm.model;

import com.zeng.ssm.common.Searchable;

import java.util.List;

public class OutputFrameData extends Searchable {
    private Integer inputFrameDataId;
//    private InputFrame inputFrame;
    private String collectionDescription;

    private List<OutputPartData> outputPartDataList;
    private List<EnvLoadData> envLoadDataList;

    public Integer getInputFrameDataId() {
        return inputFrameDataId;
    }

    public void setInputFrameDataId(Integer inputFrameId) {
        this.inputFrameDataId = inputFrameDataId;
    }

//    public InputFrame getInputFrame() {
//        return inputFrame;
//    }
//
//    public void setInputFrame(InputFrame inputFrame) {
//        this.inputFrame = inputFrame;
//    }

    public String getCollectionDescription() {
        return collectionDescription;
    }

    public void setCollectionDescription(String collectionDescription) {
        this.collectionDescription = collectionDescription;
    }

    public List<OutputPartData> getOutputPartDataList() {
        return outputPartDataList;
    }

    public void setOutputPartDataList(List<OutputPartData> outputPartDataList) {
        this.outputPartDataList = outputPartDataList;
    }

    public List<EnvLoadData> getEnvLoadDataList() {
        return envLoadDataList;
    }

    public void setEnvLoadDataList(List<EnvLoadData> envLoadDataList) {
        this.envLoadDataList = envLoadDataList;
    }
}
