package July;

public class GasStation {

    public static int canCompleteCircuit(int[]gas,int[]cost){
        int totalgas=0;
        int totalcost=0;
        for(int i=0;i<gas.length;i++){
            totalgas=gas[i];
            totalcost=cost[i];
        }
    if(totalgas<totalcost){return -1;}
    int currentGas=0;
    int currentIndex=0;

    for(int i=0;i<gas.length;i++){
        currentGas+=gas[i]-cost[i];
        if(currentGas<0){
            currentGas=0;
            currentIndex=i+1;
        }
    }
    return currentIndex;

    }

    public static void main(String[] args) {
    int[] gas={1,2,3,4,5};
    int[] cost={3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
