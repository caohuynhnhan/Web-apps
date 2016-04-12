/**
 * 
 */
package Object;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.ConnectDB;


/**
 * @author Anonymous
 *
 */
public class ProductDetails {
	private String otherconnection;
	private String detailID;
	private String network;
	private String launchDate;
	private String dimenison;
	private float weight;
	private String simCard;
	private String displayType;
	private String displaySize;
	private String displayResolution;
	private String touchScreen;
	private String os;
	private String chipset;
	private String gpu;
	private String externalSD;
	private String internalMemory;
	private String primaryCamera;
	private String cameraFeatures;
	private String video;
	private String secondaryCamera;
	private String soundType;
	private String speaker;
	private String wifi;
	private String bluetooth;
	private String gps;
	private String usb;
	private String sensor;
	private String multimeia;
	private String battery;
	private String standby;
	private String otherDescription;
	private String productName;
	private int jack35;
	private String accessories;
	
	
	public ProductDetails(){
		
	}
	public ProductDetails(String DetailID, String Network, String LaunchDate, String Dimenison, float Weight, String Simcard, String DisplayType, String DisplaySize, String DisplayResolution, String TouchScreen, String OS, String Chipset, String GPU, String ExternalSD, String InternalMemory, String PrimaryCamera, String CameraFeature, String Video, String SecondaryCamera, String SoundType, String Speaker, String Wifi, String Bluetooth, String GPS, String USB, String Sensor, String Multimedia, String Battery, String Standby, String OtherDescription, String productName, int Jack35, String Accessories, String Otherconnection){
 
		this.setOtherconnection(Otherconnection);
		this.setDetailID(DetailID);
		this.setNetwork(Network);
		this.setLaunchDate(LaunchDate);
		this.setDimenison(Dimenison);
		this.setWeight(Weight);
		this.setSimCard(Simcard);
		this.setDisplayType(DisplayType);
		this.setDisplaySize(DisplaySize);
		this.setDisplayResolution(DisplayResolution);
		this.setTouchScreen(TouchScreen);
		this.setOs(OS);
		this.setChipset(Chipset);
		this.setGpu(GPU);
		this.setExternalSD(ExternalSD);
		this.setInternalMemory(InternalMemory);
		this.setPrimaryCamera(PrimaryCamera);
		this.setCameraFeatures(CameraFeature);
		this.setVideo(Video);
		this.setSecondaryCamera(SecondaryCamera);
		this.setSoundType(SoundType);
		this.setSpeaker(Speaker);
		this.setWifi(Wifi);
		this.setBluetooth(Bluetooth);
		this.setGps(GPS);
		this.setUsb(USB);
		this.setSensor(Sensor);
		this.setMultimeia(Multimedia);
		this.setBattery(Battery);
		this.setStandby(Standby);
		this.setOtherDescription(OtherDescription);
		this.setProductName(productName);
		this.setJack35(Jack35);
		this.setAccessories(Accessories);		
		
		
	}
	/**
	 * @return the detailID
	 */
	public String getDetailID() {
		return detailID;
	}
	/**
	 * @param detailID the detailID to set
	 */
	public void setDetailID(String detailID) {
		this.detailID = detailID;
	}
	/**
	 * @return the network
	 */
	public String getNetwork() {
		return network;
	}
	/**
	 * @param network the network to set
	 */
	public void setNetwork(String network) {
		this.network = network;
	}
	/**
	 * @return the lauchDate
	 */
	public String getLaunchDate() {
		return launchDate;
	}
	/**
	 * @param lauchDate the lauchDate to set
	 */
	public void setLaunchDate(String lauchDate) {
		this.launchDate = lauchDate;
	}
	/**
	 * @return the dimenisons
	 */
	public String getDimenison() {
		return dimenison;
	}
	/**
	 * @param dimesion the dimenisons to set
	 */
	public void setDimenison(String dimenison) {
		this.dimenison = dimenison;
	}

	/**
	 * @return the simCard
	 */
	public String getSimCard() {
		return simCard;
	}
	/**
	 * @param simCard the simCard to set
	 */
	public void setSimCard(String simCard) {
		this.simCard = simCard;
	}
	/**
	 * @return the displayType
	 */
	public String getDisplayType() {
		return displayType;
	}
	/**
	 * @param displayType the displayType to set
	 */
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	/**
	 * @return the displaySize
	 */
	public String getDisplaySize() {
		return displaySize;
	}
	/**
	 * @param displaySize the displaySize to set
	 */
	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}
	/**
	 * @return the displayResolution
	 */
	public String getDisplayResolution() {
		return displayResolution;
	}
	/**
	 * @param displayResolution the displayResolution to set
	 */
	public void setDisplayResolution(String displayResolution) {
		this.displayResolution = displayResolution;
	}
	/**
	 * @return the touchScreen
	 */
	public String getTouchScreen() {
		return touchScreen;
	}
	/**
	 * @param touchScreen the touchScreen to set
	 */
	public void setTouchScreen(String touchScreen) {
		this.touchScreen = touchScreen;
	}
	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}
	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}
	/**
	 * @return the chipset
	 */
	public String getChipset() {
		return chipset;
	}
	/**
	 * @param chipset the chipset to set
	 */
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	/**
	 * @return the gpu
	 */
	public String getGpu() {
		return gpu;
	}
	/**
	 * @param gpu the gpu to set
	 */
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	/**
	 * @return the externalSD
	 */
	public String getExternalSD() {
		return externalSD;
	}
	/**
	 * @param externalSD the externalSD to set
	 */
	public void setExternalSD(String externalSD) {
		this.externalSD = externalSD;
	}
	/**
	 * @return the internalMemory
	 */
	public String getInternalMemory() {
		return internalMemory;
	}
	/**
	 * @param internalMemory the internalMemory to set
	 */
	public void setInternalMemory(String internalMemory) {
		this.internalMemory = internalMemory;
	}
	/**
	 * @return the primaryCamera
	 */
	public String getPrimaryCamera() {
		return primaryCamera;
	}
	/**
	 * @param primaryCamera the primaryCamera to set
	 */
	public void setPrimaryCamera(String primaryCamera) {
		this.primaryCamera = primaryCamera;
	}
	/**
	 * @return the cameraFeatures
	 */
	public String getCameraFeatures() {
		return cameraFeatures;
	}
	/**
	 * @param cameraFeatures the cameraFeatures to set
	 */
	public void setCameraFeatures(String cameraFeatures) {
		this.cameraFeatures = cameraFeatures;
	}
	/**
	 * @return the video
	 */
	public String getVideo() {
		return video;
	}
	/**
	 * @param video the video to set
	 */
	public void setVideo(String video) {
		this.video = video;
	}
	/**
	 * @return the secondaryCamera
	 */
	public String getSecondaryCamera() {
		return secondaryCamera;
	}
	/**
	 * @param secondaryCamera the secondaryCamera to set
	 */
	public void setSecondaryCamera(String secondaryCamera) {
		this.secondaryCamera = secondaryCamera;
	}
	/**
	 * @return the soundType
	 */
	public String getSoundType() {
		return soundType;
	}
	/**
	 * @param soundType the soundType to set
	 */
	public void setSoundType(String soundType) {
		this.soundType = soundType;
	}
	/**
	 * @return the speaker
	 */
	public String getSpeaker() {
		return speaker;
	}
	/**
	 * @param speaker the speaker to set
	 */
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	/**
	 * @return the wifi
	 */
	public String getWifi() {
		return wifi;
	}
	/**
	 * @param wifi the wifi to set
	 */
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	/**
	 * @return the bluetooth
	 */
	public String getBluetooth() {
		return bluetooth;
	}
	/**
	 * @param bluetooth the bluetooth to set
	 */
	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}
	/**
	 * @return the gps
	 */
	public String getGps() {
		return gps;
	}
	/**
	 * @param gps the gps to set
	 */
	public void setGps(String gps) {
		this.gps = gps;
	}
	/**
	 * @return the usb
	 */
	public String getUsb() {
		return usb;
	}
	/**
	 * @param usb the usb to set
	 */
	public void setUsb(String usb) {
		this.usb = usb;
	}
	/**
	 * @return the sensor
	 */
	public String getSensor() {
		return sensor;
	}
	/**
	 * @param sensor the sensor to set
	 */
	public void setSensor(String sensor) {
		this.sensor = sensor;
	}
	/**
	 * @return the multimeia
	 */
	public String getMultimeia() {
		return multimeia;
	}
	/**
	 * @param multimeia the multimeia to set
	 */
	public void setMultimeia(String multimeia) {
		this.multimeia = multimeia;
	}
	/**
	 * @return the battery
	 */
	public String getBattery() {
		return battery;
	}
	/**
	 * @param battery the battery to set
	 */
	public void setBattery(String battery) {
		this.battery = battery;
	}
	/**
	 * @return the standby
	 */
	public String getStandby() {
		return standby;
	}
	/**
	 * @param standby the standby to set
	 */
	public void setStandby(String standby) {
		this.standby = standby;
	}
	/**
	 * @return the otherDescription
	 */
	public String getOtherDescription() {
		return otherDescription;
	}
	/**
	 * @param otherDescription the otherDescription to set
	 */
	public void setOtherDescription(String otherDescription) {
		this.otherDescription = otherDescription;
	}
	
	
	
	
	public static ArrayList<ProductDetails> getAllProductDetail() throws Exception{
		ArrayList<ProductDetails> lst = new ArrayList<>();
		String sql = "select * from productdetails";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String accessories = rs.getString("accessories");
				String otherconnection = rs.getString("otherconnection");
				int jack35 = rs.getInt("jack35");
				String detailID = rs.getString("detailid");
				String network = rs.getString("network");
				String luanchDay = rs.getString("launchdate");
				String dimenison = rs.getString("dimenison");
				float weight = rs.getFloat("weight");
				String simcard = rs.getString("simcard");
				String displayType = rs.getString("displaytype");
				String displaySize = rs.getString("displaysize");
				String displayResolution = rs.getString("displayresolution");
				String touchscreen = rs.getString("touchscreen");
				String os = rs.getString("os");
				String chipset = rs.getString("chipset");
				String gpu = rs.getString("gpu");
				String externalSd = rs.getString("externalsd");
				String internalMem = rs.getString("internalmemory");
				String priCam = rs.getString("primarycamera");
				String camfeatures = rs.getString("camerafeatures");
				String video = rs.getString("video");
				String seconCam = rs.getString("secondarycamera");
				String soundType = rs.getString("soundtype");
				String speaker = rs.getString("speaker");
				String wifi = rs.getString("wifi");
				String bluetooth = rs.getString("bluetooth");
				String gps = rs.getString("gps");
				String usb = rs.getString("usb");
				String sensor = rs.getString("sensor");
				String multiMedia = rs.getString("multimedia");
				String battery = rs.getString("battery");
				String standby = rs.getString("standby");
				String otherdescription = rs.getString("otherdescriptions");				
				String productName = rs.getString("productname");
				ProductDetails prodl = new ProductDetails(detailID, network, luanchDay, dimenison, weight, simcard, displayType, displaySize, displayResolution, touchscreen, os, chipset, gpu, externalSd, internalMem, priCam, camfeatures, video, seconCam, soundType, speaker, wifi, bluetooth, gps, usb, sensor, multiMedia, battery, standby, otherdescription, productName, jack35, accessories, otherconnection);

				
				
				

				
				lst.add(prodl);
			}
						
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return lst;
	}	
	
	
	
	public static ProductDetails getProductDetailByID(String prodlID) throws Exception{
		ProductDetails prodl = null;
		String sql = "select * from productdetails where detailid=?";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, prodlID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){	
				String detailID = rs.getString("detailid");
				String network = rs.getString("network");
				String luanchDay = rs.getString("launchdate");
				String dimenison = rs.getString("dimenison");
				float weight = rs.getFloat("weight");
				String simcard = rs.getString("simcard");
				String displayType = rs.getString("displaytype");
				String displaySize = rs.getString("displaysize");
				String displayResolution = rs.getString("displayresolution");
				String touchscreen = rs.getString("touchscreen");
				String os = rs.getString("os");
				String chipset = rs.getString("chipset");
				String gpu = rs.getString("gpu");
				String externalSd = rs.getString("externalsd");
				String internalMem = rs.getString("internalmemory");
				String priCam = rs.getString("primarycamera");
				String camfeatures = rs.getString("camerafeatures");
				String video = rs.getString("video");
				String seconCam = rs.getString("secondarycamera");
				String soundType = rs.getString("soundtype");
				String speaker = rs.getString("speaker");
				String wifi = rs.getString("wifi");
				String bluetooth = rs.getString("bluetooth");
				String gps = rs.getString("gps");
				String usb = rs.getString("usb");
				String sensor = rs.getString("sensor");
				String multiMedia = rs.getString("multimedia");
				String battery = rs.getString("battery");
				String standby = rs.getString("standby");
				String otherdescription = rs.getString("otherdescriptions");
				int jack35 = rs.getInt("jack35");
				String accessories = rs.getString("accessories");
				String otherconnection = rs.getString("otherconnection");
				String productName = rs.getString("productname");
				
				
				prodl = new ProductDetails(detailID, network, luanchDay, dimenison, weight, simcard, displayType, displaySize, displayResolution, touchscreen, os, chipset, gpu, externalSd, internalMem, priCam, camfeatures, video, seconCam, soundType, speaker, wifi, bluetooth, gps, usb, sensor, multiMedia, battery, standby, otherdescription, productName, jack35, accessories, otherconnection);
				
				
			}	

				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return prodl;
	}	
	
	
	
	
	public boolean deleteProductDetail() throws Exception{
		
		String sql = "delete from productdetails where detailid=?";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, this.getDetailID());
			return pst.executeUpdate()>0;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return false;
	}
	
	
	public boolean updateProductDetail(ProductDetails prodl) throws Exception{
		

		String sql = "update productdetails set detailid=?, network=?, launchdate=?, dimenison=?, weight=?, simcard=?, displaytype=?, displaysize=?, displayresolution=?, touchscreen=?, os=?, chipset=?, gpu=?, externalsd=?, internalmemory=?, primarycamera=?, camerafeatures=?, video=?, secondarycamera=?, soundtype=?, speaker=?, wifi=?, bluetooth=?, gps=?, usb=?, sensor=?, multimedia=?, battery=?, standby=?, otherdescriptions=?, productname=?, jack35=?, accessories=?, otherconnection=? where detailid=?";

		

		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, prodl.getDetailID());
			pst.setString(2, prodl.getNetwork());
			pst.setString(3, prodl.getLaunchDate());
			pst.setString(4, prodl.getDimenison());
			pst.setFloat(5, prodl.getWeight());
			pst.setString(6, prodl.getSimCard());
			pst.setString(7, prodl.getDisplayType());
			pst.setString(8, prodl.getDisplaySize());
			pst.setString(9, prodl.getDisplayResolution());
			pst.setString(10, prodl.getTouchScreen());			
			pst.setString(11, prodl.getOs());
			pst.setString(12, prodl.getChipset());
			pst.setString(13, prodl.getGpu());
			pst.setString(14, prodl.getExternalSD());
			pst.setString(15, prodl.getInternalMemory());
			pst.setString(16, prodl.getPrimaryCamera());
			pst.setString(17, prodl.getCameraFeatures());
			pst.setString(18, prodl.getVideo());
			pst.setString(19, prodl.getSecondaryCamera());
			pst.setString(20, prodl.getSoundType());
			pst.setString(21, prodl.getSpeaker());
			pst.setString(22, prodl.getWifi());
			pst.setString(23, prodl.getBluetooth());
			pst.setString(24, prodl.getGps());
			pst.setString(25, prodl.getUsb());
			pst.setString(26, prodl.getSensor());
			pst.setString(27, prodl.getMultimeia());
			pst.setString(28, prodl.getBattery());

			pst.setString(29, prodl.getStandby());			
			pst.setString(30, prodl.getOtherDescription());
			pst.setString(31, prodl.getProductName());
			pst.setInt(32, prodl.getJack35());
			pst.setString(33, prodl.getAccessories());
			pst.setString(34, prodl.getOtherconnection());
			pst.setString(35, this.getDetailID());

			

		
			return pst.executeUpdate()>0;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return false;
	}
	
	
	
	public boolean insertProductDetail() throws Exception{
		

		String sql = "insert into productdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, this.getDetailID());
			pst.setString(2, this.getNetwork());
			pst.setString(3, this.getLaunchDate());
			pst.setString(4, this.getDimenison());
			pst.setFloat(5, this.getWeight());
			pst.setString(6, this.getSimCard());
			pst.setString(7, this.getDisplayType());
			pst.setString(8, this.getDisplaySize());
			pst.setString(9, this.getDisplayResolution());
			pst.setString(10, this.getTouchScreen());			
			pst.setString(11, this.getOs());
			pst.setString(12, this.getChipset());
			pst.setString(13, this.getGpu());
			pst.setString(14, this.getExternalSD());
			pst.setString(15, this.getInternalMemory());
			pst.setString(16, this.getPrimaryCamera());
			pst.setString(17, this.getCameraFeatures());
			pst.setString(18, this.getVideo());
			pst.setString(19, this.getSecondaryCamera());
			pst.setString(20, this.getSoundType());
			pst.setString(21, this.getSpeaker());
			pst.setString(22, this.getWifi());
			pst.setString(23, this.getBluetooth());
			pst.setString(24, this.getGps());
			pst.setString(25, this.getUsb());
			pst.setString(26, this.getSensor());
			pst.setString(27, this.getMultimeia());
			pst.setString(28, this.getBattery());
			pst.setString(29, this.getStandby());
			pst.setString(30, this.getOtherDescription());

			pst.setString(31, this.getProductName());
			pst.setInt(32, this.getJack35());
			pst.setString(33, this.getAccessories());
			pst.setString(34, this.getOtherconnection());
			if(pst.executeUpdate()>0)
			return defaultValues.increaseDefaultValue("currentproductdetail");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return false;

	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;

	}
	public int getJack35() {
		return jack35;
	}
	public void setJack35(int jack35) {
		this.jack35 = jack35;
	}
	public String getAccessories() {
		return accessories;
	}
	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}
	public String getOtherconnection() {
		return otherconnection;
	}
	public void setOtherconnection(String otherconnection) {
		this.otherconnection = otherconnection;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}	
}
