package org.oep.core.thamso.action;

import javax.servlet.http.HttpServletRequest;

import org.oep.core.form.ActionForm;
import org.oep.core.form.data.checker.DefaultDataChecker;
import org.oep.core.form.data.checker.MaxLengthDataChecker;
import org.oep.core.form.data.checker.NonArrayDataChecker;
import org.oep.core.keys.ThamSoKeys;
import org.oep.core.model.ThamSo;
import org.oep.core.service.ThamSoLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class ThamSoForm extends ActionForm{
private static Log log = LogFactoryUtil.getLog(ThamSoForm.class);
	
	public long thamSoId;
	public long loaiId;
	public String ma = "";
	public String giaTri = "";
	public String moTa = "";	
	public boolean trangThai = true;
	
private void initValidator(){
		
		addValidator("ma", "org.oep.core.portlet.thamso.message.empty.ma", new DefaultDataChecker());
		
		addValidator("ma", "org.oep.core.portlet.thamso.message.duplicate.ma", new NonArrayDataChecker(){
			@Override
			public boolean validate(Object ma) {				
				try {
					for(ThamSo thamSo : ThamSoLocalServiceUtil.getByMa(String.valueOf(ma))){
						if(thamSo.getId() != thamSoId){
//							System.out.println("thamSo.getId()=" + thamSo.getId());
//							System.out.println("thamSoId=" + thamSoId);
							return false;
						}
					}
					return true;
				} catch (SystemException e) {
					log.error(e);
				}
				return true;
			}			
		});
		
		addValidator("ma", "org.oep.core.portlet.thamso.message.toolong.ma", new MaxLengthDataChecker(ThamSoKeys.Base.MA_MAX_LENGTH));	
		
	}

public ThamSoForm(){
	initValidator();
}

public ThamSoForm(HttpServletRequest request) throws SystemException{
	thamSoId = ParamUtil.getLong(request, "thamSoId");
	
	if(thamSoId != 0){
		ThamSo thamSo = ThamSoLocalServiceUtil.fetchThamSo(thamSoId);
		if(thamSo != null){
			this.ma = thamSo.getMa();
			this.loaiId = thamSo.getLoaiId();
			this.giaTri = thamSo.getGiaTri();
			this.moTa = thamSo.getMoTa();
			this.trangThai = thamSo.getTrangThai();
		}
	}
	
	initValidator();
}
}
