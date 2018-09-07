package wxlogin;

public class Test2 {
	public static void main(String[] args) {

		demo2(6);
	}

	/**
	 * 
	 */
	static void demo1(Integer vmId) {
		String vmIds = "1-1-6;1-1-4;1-1-5";
		String vmNames = "asd-38c99eb7-7681-4b3e-bb8a-f70664f32481;bbbb-34c52877-ce4b-42fc-a736-50e9781b2f6c;vir-7c63c4ab-dd13-4ec9-9086-aad7b493856d";
		String newVmIds = "";
		String newVmNames = "";
		String[] vmIdsArray = vmIds.split(";");
		String[] vmNamesArray = vmNames.split(";");
		for (int i = 0; i < vmIdsArray.length; i++) {
			String strVmId = vmIdsArray[i].split("-")[2];
			if (!strVmId.equals(vmId.toString())) {
				newVmIds += vmIdsArray[i] + ";";
				newVmNames += vmNamesArray[i] + ";";
			}

		}
		newVmIds = newVmIds.substring(0, newVmIds.length() - 1);
		newVmNames = newVmNames.substring(0, newVmNames.length() - 1);
		System.out.println("ÐéÄâ»úid£º" + newVmIds);
		System.out.println("ÐéÄâ»úname:" + newVmNames);
	}
	
	
	static void demo2(Integer vmId) {
		String vmIds = "1-1-6;1-1-4;1-1-5";
		String vmNames = "asd-38c99eb7-7681-4b3e-bb8a-f70664f32481;bbbb-34c52877-ce4b-42fc-a736-50e9781b2f6c;vir-7c63c4ab-dd13-4ec9-9086-aad7b493856d";
		String newVmIds = "";
		String newVmNames = "";
		String[] vmIdsArray = vmIds.split(";");
		String[] vmNamesArray = vmNames.split(";");
		for (int i = 0; i < vmIdsArray.length; i++) {
			String strVmId = vmIdsArray[i].split("-")[2];
			
			
			if (!strVmId.equals(vmId.toString())) {
				
			}

		}
		newVmIds = newVmIds.substring(0, newVmIds.length() - 1);
		newVmNames = newVmNames.substring(0, newVmNames.length() - 1);
		System.out.println("ÐéÄâ»úid£º" + newVmIds);
		System.out.println("ÐéÄâ»úname:" + newVmNames);
	}
}
