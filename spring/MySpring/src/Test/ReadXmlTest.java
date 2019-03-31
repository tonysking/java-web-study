package Test;

import java.util.Map;

import org.junit.Test;

import config.Bean;
import config.parse.ConfigManager;

public class ReadXmlTest {

	//测试读取配置文件的ConfigManager
	@Test
	public void test() {
		Map<String, Bean> config = ConfigManager.getConfig("/applicationContext.xml");
		System.out.println(config);
	}
}
