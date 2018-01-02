package tacos.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import exemplo.tacos.TacoCloudApplication;

@RunWith(SpringRunner.class)
@WebMvcTest(TacoCloudApplication.class)
public class HomeControllerTest {
	
//	@Autowired
//	private MockMvc mockMvc;
//	@Test
//	public void testHomePage() throws Exception {
//		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"))
//				.andExpect(content().string(containsString("Welcome to...")));
//	}

}
