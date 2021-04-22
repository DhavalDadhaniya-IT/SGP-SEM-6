package FF;

public class EDGE {
    double resourceCapacity, freeCapacity, usedCapacity;
    int edgeid;
    static int edgeCounter = 0;
    double req[];
    double reqResource[], ru = 0, ns = 0, b=0, lb = 0;
    double startTime[];
    double endTime[];

    public EDGE(){
        this.edgeid = edgeCounter++;
        this.resourceCapacity = 7;
        reqResource = new double[0];
        freeCapacity = resourceCapacity;
        usedCapacity = 0;
        startTime = new double[0];
        endTime = new double[0];
        req = new double[0];
    }


    public double getResourceCapacity() {
        return resourceCapacity;
    }

    public void setReq(double reqId, double startTime, double duration, double reqResource)throws Exception {
        double tempId[] = new double[this.req.length+1];
        for(int i=0;i<req.length;i++){
            tempId[i] = req[i];
        }
        tempId[req.length] = reqId;
        req = tempId;


        double tempStartTime[] = new double[this.startTime.length+1];
        for(int i=0;i<this.startTime.length;i++){
            tempStartTime[i] = this.startTime[i];
        }
        tempStartTime[this.startTime.length] = startTime;
        this.startTime = tempStartTime;

        double tempReqResource[] = new double[this.reqResource.length+1];
        for(int i=0;i<this.reqResource.length;i++){
            tempReqResource[i] = this.reqResource[i];
        }
        tempReqResource[this.reqResource.length] = reqResource;
        this.reqResource = tempReqResource;

        double tempEndTime[] = new double[this.endTime.length+1];
        for(int i=0;i<this.endTime.length;i++){
            tempEndTime[i] = this.endTime[i];
        }
        tempEndTime[this.endTime.length] = startTime + duration;
        this.endTime = tempEndTime;

        this.usedCapacity = this.usedCapacity + reqResource;
        this.freeCapacity = this.resourceCapacity - this.usedCapacity;
    }
}
