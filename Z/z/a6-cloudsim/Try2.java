
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

public class Try2 {
	
	private static List<Cloudlet> cloudletList;
	private static List<Vm> vmList;
	
	public static void main(String[] args) {

		//step1: Initialize Cloudsim
		CloudSim.init(1, Calendar.getInstance(), false);
		
		//step2: Create Datacenter
		Datacenter datacenter0 = createDatacenter("Datacenter0");
		
		//step3: Create Broker
		DatacenterBroker broker = createBroker();
		int brokerId = broker.getId();
		
		//step4: Create Vm
		vmList = new ArrayList<Vm>();
		Vm vm = new Vm(0,brokerId,1000,1,512,1000,10000,"Xen",new CloudletSchedulerTimeShared());
		
		//add vm to vmList
		vmList.add(vm);
		
		//submit vmList to broker
		broker.submitVmList(vmList);
		
		//step5: Create Cloudlet
		cloudletList = new ArrayList<Cloudlet>();
		Cloudlet cloudlet = new Cloudlet(0,4000000,1,300,300,new UtilizationModelFull(),new UtilizationModelFull(),new UtilizationModelFull());
		cloudlet.setUserId(brokerId);
		cloudlet.setVmId(0);
		
		//add cloudlet to cloudletList
		cloudletList.add(cloudlet);
		
		//submit cloudletList to broker
		broker.submitCloudletList(cloudletList);
		
		//step6: Start Simulation
		CloudSim.startSimulation();
		
		CloudSim.stopSimulation();
		
		//step7: Print Cloudlet
		List<Cloudlet> newlist = broker.getCloudletReceivedList();
		printCloudList(newlist);

	}
	
	private static Datacenter createDatacenter(String name) {
		
		//create pelist
		List<Pe> pelist = new ArrayList<Pe>();
		pelist.add(new Pe(0,new PeProvisionerSimple(1000)));
		
		//create hostlist
		List<Host> hostlist = new ArrayList<Host>();
		hostlist.add(new Host(0,new RamProvisionerSimple(2048),new BwProvisionerSimple(1000),1000000,pelist,new VmSchedulerTimeShared(pelist)));
		
		//create storage
		List<Storage> storage = new ArrayList<Storage>();
		
		//create Datacenter Configuration
		DatacenterCharacteristics chara = new DatacenterCharacteristics("x86","Linux","Xen",hostlist,10.00,3.0,0.05,0.01,0.0);
		
		//power Datacenter
		Datacenter datacenter = null;
		try {
			datacenter = new Datacenter(name,chara,new VmAllocationPolicySimple(hostlist),storage,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datacenter;
		
	}
	
	private static DatacenterBroker createBroker() {
		DatacenterBroker broker = null;
		try {
			broker = new DatacenterBroker("Broker");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return broker;
	}
	
	private static void printCloudList(List<Cloudlet>list) {
		int size = list.size();
		Cloudlet cloudlet;

		for(int i=0;i<size;i++) {
			cloudlet = list.get(i);
			System.out.println("Cloudlet ID: "+cloudlet.getCloudletId());
			System.out.println("Status: "+cloudlet.getCloudletStatusString());
			System.out.println("Actual CPU time: "+cloudlet.getActualCPUTime());
			System.out.println("Number of Proecessors: "+cloudlet.getNumberOfPes());
			System.out.println("VM ID: "+cloudlet.getVmId());
			System.out.println("Broker ID: "+cloudlet.getUserId());
			System.out.println("Datacenter ID: "+cloudlet.getResourceId());
		}
	}

}

