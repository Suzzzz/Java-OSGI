package calculatorservice;

public class CalculatorServiceImpl implements CalculatorService{

	public CalculatorServiceImpl(){
		
	}

	public double Calculate(double no1, double no2, String sign) {

		if(sign.equals("+")){
			return no1+no2;
		}
		else if (sign.equals("-")){
			return no1-no2;
		}
		else if (sign.equals("/")){
			return no1/no2;
		}
		
		else if (sign.equals("*")){
			return no1*no2;
		}
		else {
			return 0.0;
		}
		
	}
}
