package ru.neoflex.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalcControllerMockMvcTest {

	@Autowired
	private MockMvc mockMvc; // injected with @AutoConfigureMockMvc

	@Test
	public void plusTestPositive() throws Exception {
		this.mockMvc
				.perform(get("/plus/5/7"))
				.andDo(print())
				.andExpect(content().string("12"));
	}
	@Test
	public void plusTestNegative() throws Exception {
		this.mockMvc
				.perform(get("/plus/-7/-10"))
				.andDo(print())
				.andExpect(content().string("-17"));
	}
	@Test
	public void plusTestZero() throws Exception {
		this.mockMvc
				.perform(get("/plus/-4/4"))
				.andDo(print())
				.andExpect(content().string("0"));
	}
	@Test
	public void plusTestSame() throws Exception {
		this.mockMvc
				.perform(get("/plus/11/11"))
				.andDo(print())
				.andExpect(content().string("22"));
	}
	@Test
	public void plusTestStatus404() throws Exception {
		this.mockMvc
				.perform(get("/plus/922"))
				.andDo(print())
				.andExpect(status().is(404));
	}
	@Test
	public void minusTestNegative() throws Exception {
		this.mockMvc
				.perform(get("/minus/5/7"))
				.andDo(print())
				.andExpect(content().string("-2"));
	}
	@Test
	public void minusTestPositive() throws Exception {
		this.mockMvc
				.perform(get("/minus/10/4"))
				.andDo(print())
				.andExpect(content().string("6"));
	}
	@Test
	public void minusTestZero() throws Exception {
		this.mockMvc
				.perform(get("/minus/22/22"))
				.andDo(print())
				.andExpect(content().string("0"));
	}
	@Test
	public void minusTestStatus404() throws Exception {
		this.mockMvc
				.perform(get("/minus/5"))
				.andDo(print())
				.andExpect(status().is(404));
	}
}
