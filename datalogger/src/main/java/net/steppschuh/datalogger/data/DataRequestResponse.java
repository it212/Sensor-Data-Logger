package net.steppschuh.datalogger.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class DataRequestResponse {

    private List<DataBatch> dataBatches;
    private long startTimestamp;
    private long endTimestamp;

    public DataRequestResponse(List<DataBatch> dataBatches) {
        this.dataBatches = dataBatches;
        endTimestamp = System.currentTimeMillis();
    }

    @JsonIgnore
    @Override
    public String toString() {
        return toJson();
    }

    @JsonIgnore
    public String toJson() {
        String jsonData = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            jsonData = mapper.writeValueAsString(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonData;
    }

    public List<DataBatch> getDataBatches() {
        return dataBatches;
    }

    public void setDataBatches(List<DataBatch> dataBatches) {
        this.dataBatches = dataBatches;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }
}
