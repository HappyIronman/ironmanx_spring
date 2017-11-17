package test;

import com.ironman.aopTest.Performance;
import com.ironman.defaultBean.Bean1;
import com.ironman.defaultBean.TestBean1;
import com.ironman.service.Servicex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 17:12 2017/10/18 0018
 * @Modified by:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.ironman.config.Config.class)
public class test {
	@Autowired
	private Bean1 bean1;

	@Autowired
	Performance performance;
//	@Autowired
//	private Servicex servicex;
//	@Autowired
//	private TestBean1 testBeanX;

	@Test
	public void ttt(){
//		servicex.printSth("eee");
//		bean1.print();
//		System.out.println(testBeanX.toString());
		performance.perform("sing");
	}
}
