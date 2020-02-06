package com.ust.mail_simulation.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ust.mail_simulation.dao.MyDAO;
import com.ust.mail_simulation.model.MailDTO;
import com.ust.mail_simulation.model.UserDTO;
@Component
public class MyServiceImpl1 implements MyService {
	@Autowired
	MyDAO mdao;

	@Override
	public boolean register(UserDTO dto) {
		boolean b =mdao.register(dto);
		return b;
	}
	@Override
	public UserDTO login(UserDTO dto) {
		UserDTO udto=mdao.login(dto);
		return udto;
	}
	@Override
	public List<MailDTO> inbox() {
		List<MailDTO> From_id=mdao.inbox();
		return From_id;
	}
	@Override
	public List<MailDTO> sentitem() {
		List<MailDTO> From_id=mdao.sentitem();
		return From_id;
	}
	@Override
	public List<MailDTO> deleteitem() {
		List<MailDTO> From_id=mdao.deleteitem();
		return From_id;
	}
	@Override
	public List<MailDTO> draft() {
		List<MailDTO> From_id=mdao.draft();
		return From_id;
	}
	@Override
	public boolean composeEmail(HttpServletRequest req) {
		return mdao.composeEmail(req);
	}
	@Override
	public boolean forgotpasswword(HttpServletRequest req) {
		return mdao.forgotpassword(req);
	}
	@Override
	public boolean changePass(HttpServletRequest req) {
		boolean b= mdao.changePass(req);
	return b;
	}
	@Override
	public List<MailDTO> mail(int id) {
		List<MailDTO> From_id=mdao.mail(id);
		return From_id;
	}
	@Override
	public MailDTO composedraft(int id) {
		MailDTO From_id=mdao.composedraft(id);
		return From_id;
	}
	@Override
	public boolean composedraftEmail(HttpServletRequest req) {
		return mdao.composedraftEmail(req);
	}
	@Override
	public boolean sentdelete(int id) {
		boolean b=mdao.sentdelete(id);
		return b;
	}
	@Override
	public boolean inboxdelete(int id) {
		boolean b=mdao.inboxdelete(id);
		return b;
	}
	@Override
	public boolean draftdelete(int id) {
		boolean b=mdao.draftdelete(id);
		return b;
	}
}
