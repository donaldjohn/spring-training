import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cog.Calculator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestCalculator {
	
	@Autowired
	private Calculator calc;

	/*@Before
	public void setup(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); 
		calc = context.getBean(Calculator.class);
	}*/

	@Test
	public void testSquareof9(){
		
		int input = 9;
		int result = calc.square(input);
		System.out.println(result);
		assertEquals("9 square should be 81", 81, result);
		
	}
	
	@Test
	public void testSquareofNegative9(){
		
		int input = -9;
		int result = calc.square(input);
		System.out.println(result);
		assertEquals("-9 square should be 81", 81, result);
		
	}
	
	

}
