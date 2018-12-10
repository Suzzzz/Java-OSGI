package calculatorsubscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import calculatorservice.CalculatorService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceReference seriveReference;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Calculator Service Started");
		
		seriveReference = context.getServiceReference(CalculatorService.class.getName());
		CalculatorService calcService = (CalculatorService) context.getService(seriveReference);
		
		double no1, no2;
		String sign;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Sign");
			sign = in.readLine();
		System.out.println("Enter number 1: ");
			no1 = Double.valueOf(in.readLine()).doubleValue();
		System.out.println("Enter number 2: ");
			no2 = Double.valueOf(in.readLine()).doubleValue();
			
			if(no1 ==0 | no2 == 0)
			{
				System.out.println("Cannot devide by zero");
			}
			else if (sign.equals(null) | sign.equals(""))
			{
				System.out.println("Enter a sign");
			}
			if(sign.equals("*") | sign.equals("+")| sign.equals("-") | sign.equals("/") )
			{
				System.out.println("Answer is "+ calcService.Calculate(no1,no2,sign));
			}
			else {
				System.out.println("Enter a valid operator");

    }
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
