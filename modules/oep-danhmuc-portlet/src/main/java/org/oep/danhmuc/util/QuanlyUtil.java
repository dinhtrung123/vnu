package org.oep.danhmuc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.oep.danhmuc.exception.FileTypeNotSupportException;
import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.service.DanhMucLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.PrimitiveLongList;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

public class QuanlyUtil {
	public static String genHtmlString(long selectedId, String nameSpace) throws PortalException, SystemException{
		String result = "";
		DanhMuc item = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId);
		if(item != null){
			String maGiaPha = item.getMaGiaPha();
			if(!maGiaPha.isEmpty()){
				String[] maGiaPhaArr = maGiaPha.split(",");
				for(int i = 0; i < maGiaPhaArr.length; i ++){
					boolean isActive = false;
					DanhMuc giaPha = DanhMucLocalServiceUtil.getDanhMuc_By_Ma(maGiaPhaArr[i], isActive);
					result += " <label style = 'color: 	#5DBCD2'>>></label> <a href = '#' onclick = '"+ nameSpace +"xemCap(" + giaPha.getId() + ")'>" + giaPha.getTen() + "</a>";
				}
			}
			result += " <label style = 'color: 	#5DBCD2'>>></label> <a href = '#' onclick = '"+nameSpace+"xemCap(" + item.getId() + ")'>" + item.getTen() + "</a>";
		}
		return result;
	}

	public static long[] convertToLongArray(String source, String separate) {
		PrimitiveLongList temp = new PrimitiveLongList();
		if (source != null) {
			String[] array = source.split(separate);
			if (array != null && array.length > 0) {
				for (String item : array) {
					try {
						temp.add(Long.parseLong(item.trim()));
					} catch (NumberFormatException ex) {						
					}
				}
			}
		}
		return temp.getArray();
	}
	
	public static String getUploadFileFormat(File file){
		if(file.canRead()){
			String fileName = file.getName();
			try{
				return fileName.substring(fileName.lastIndexOf(".") +1);
			}
			catch (Exception e){
				return StringPool.BLANK;
			}
		}
		return StringPool.BLANK;
	}
	
	public static List<String> importCSVFile(File file) throws PortalException, IOException{
		if(file.canRead()){
			List<String> listDanhMuc = new ArrayList<String>();
			String format = getUploadFileFormat(file);
			if(format == "csv" || format.equals("csv")){
				BufferedReader bufferReader = new BufferedReader(new FileReader(file));
				bufferReader.readLine();
				String line = null;
				while((line = bufferReader.readLine()) != null){
					listDanhMuc.add(line);
				}
				return listDanhMuc;
			}
			else{
				throw new FileTypeNotSupportException();
			}
		}
		else{
			throw new FileNotFoundException();
		}
	}
	
	public static byte[] exportCSVFile(List<DanhMuc> listRecords){
		StringBundler sb = new StringBundler();
		sb.append("\uFEFF");
		String[] headers = {"Ten", "Ma", "Mota", "Trangthai"};
		for(String s : headers){
			sb.append(s);
			sb.append(",");
		}
		sb.setIndex(sb.index()-1);
		sb.append(CharPool.NEW_LINE);
		for(DanhMuc i: listRecords){
			sb.append(i.getTen());
			sb.append(",");
			sb.append(i.getMa());
			sb.append(",");
			sb.append(i.getMoTa());
			sb.append(",");
			sb.append(i.getTrangThai()?"1":"0");
			sb.append(CharPool.NEW_LINE);
		}
		return sb.toString().getBytes();
	}
	
}
