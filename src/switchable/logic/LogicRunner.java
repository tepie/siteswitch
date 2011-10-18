package switchable.logic;

import siteswitch.config.SwitchConfigurationReader;
import switchable.objects.SwitchableObj1;
import switchable.objects.SwitchableObj2;



/**
 * This is an example logic container
 * 
 * 
 * This class is a main entry point and simulates the controller
 * to control and and wrap other flow. We can switch the controller
 * or the sub logic within the controller. 
 * 
 * @author terrence.pietrondi
 *
 */
public class LogicRunner {

	public void main(){
		SwitchConfigurationReader conf = SwitchConfigurationReader.getInstance();
		
		if(conf.isComponentOn(LogicRunner.class.getName())){
		
			if(conf.isComponentOn(SwitchableObj1.class.getName())){
				SwitchableObj1 step1 = new SwitchableObj1();
				step1.performExecute();
			} else {
				System.err.println("Can't run step 1");
			}
			
			if(conf.isComponentOn(SwitchableObj2.class.getName())){
				SwitchableObj2 step2 = new SwitchableObj2();
				step2.performExecute();
			} else {
				System.err.println("Cant't run step 2");
			}
		} else {
			System.err.println("Cant't run the logic container");
		}

	}
	
	/**
	 * Loads up some classes and tries to run them
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LogicRunner	 runner = new LogicRunner();
		runner.main();
	}

}
