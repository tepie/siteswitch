package siteswitch.config;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


/**
 * 
 * The configuration reader to contain the switches for your site
 * 
 * @author terrence.pietrondi
 *
 */
public class SwitchConfigurationReader {
	
	/**
	 * Null constructor
	 */
	private SwitchConfigurationReader(){
		
	}
	
	/**
	 * Fetch an instance of the configuration
	 * 
	 * Sets the resource bundle and populates the switches
	 * 
	 * @return static singleton of the configuration
	 */
	public static synchronized SwitchConfigurationReader getInstance(){
		if ( reference == null){
			reference = new SwitchConfigurationReader();
			reference.setRb(ResourceBundle.getBundle(RB_NAME));
			reference.populateSwitches();
		}
		
		return reference;
	}
	
	/**
	 * Prevent the cloning of the reference to ensure a single instance
	 * 
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	/**
	 * Determines if the component is on
	 * 
	 * The component string can be whatever, but by default, the 
	 * full class names are used via the resource bundle as
	 * a configured component. 
	 * 
	 * @param component
	 * @return
	 */
	public boolean isComponentOn(String component){
		if(getSwitchModel() == null){
			return true;
		} else if (!getSwitchModel().containsKey(component)){
			return true;
		} else {
			return Boolean.parseBoolean(getSwitchModel().get(component).get(getSwitchActiveKey()));
		}
	}
	
	protected synchronized void populateSwitches(){
		
		if(getSwitchModel() == null){
		
			setSwitchModel(new HashMap<String,Map<String,String>>());
			
			Enumeration<String> switchEnum = getRb().getKeys();
			while(switchEnum.hasMoreElements()){
				String switchEntry = switchEnum.nextElement();
				String switchValue = getRb().getString(switchEntry);
				
				String[] switchValuesSplit = switchValue.split(RB_SWITCH_VALUE_SPLITTER);
				Map <String, String> switchValueMap = mapSplitValues(switchValuesSplit);
				
				getSwitchModel().put(switchValueMap.get(SWITCH_EXPECTED_COLUMNS[SWITCH_MODEL_MAP_KEY]), switchValueMap);
			}
		
		}
	}
	
	protected synchronized Map <String, String> mapSplitValues(String[] switchValuesSplit){
		
		Map <String, String> switchValueMap = new HashMap<String,String>(SWITCH_EXPECTED_COLUMNS.length);
		for(int i = 0; i < SWITCH_EXPECTED_COLUMNS.length; i++){
			switchValueMap.put(SWITCH_EXPECTED_COLUMNS[i], switchValuesSplit[i]);
		}
		
		return switchValueMap;
		
	}
	
	public ResourceBundle getRb() {
		return rb;
	}
	
	public void setRb(ResourceBundle rb) {
		this.rb = rb;
	}
	
	
	public Map<String, Map<String, String>> getSwitchModel() {
		return switchModel;
	}


	public void setSwitchModel(Map<String, Map<String, String>> switchModel) {
		this.switchModel = switchModel;
	}
	
	public String getSwitchActiveKey(){
		return SWITCH_EXPECTED_COLUMNS[SWITCH_ACTIVE_KEY];
	}

	private ResourceBundle rb = null;
	private Map<String,Map<String,String>> switchModel = null;
	
	private static SwitchConfigurationReader reference = null;
	
	public static final String RB_NAME = "site_switches";
	public static final String RB_SWITCH_VALUE_SPLITTER = ",";
	public static final int SWITCH_MODEL_MAP_KEY = 2;
	public static final int SWITCH_ACTIVE_KEY = 3;
	public static final String[] SWITCH_EXPECTED_COLUMNS = {"switch_id","switch_isolation","switch_component","switch_active"};
	
}
