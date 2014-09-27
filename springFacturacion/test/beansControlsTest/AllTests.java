package beansControlsTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author musef
 *
 * @version 1.1.0_Spring LAST TEST 2014-09-25
 */


@RunWith(Suite.class)
@SuiteClasses({ TestAlbaranesBean.class, TestClientesBean.class,
		TestEmpresaBean.class, TestFacturasBean.class, TestPagosBean.class,
		TestTiposIrpfBean.class, TestTiposIvaBean.class,
		TestUtilsFacturacion.class })
public class AllTests {

}