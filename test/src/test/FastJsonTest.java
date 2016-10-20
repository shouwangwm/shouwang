package test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class FastJsonTest {
	
	
	public static void main(String[] args) {
		
		List<GoodsSkuModifyDto> list = new ArrayList<GoodsSkuModifyDto>();
		GoodsSkuModifyDto d1 = new GoodsSkuModifyDto();
//		d1.setApprovalStatus(1);
//		d1.setGoodsSkuID("sdafjalsdkg123jlsaskjdfl123");
//		d1.setGoodsID("adsgqweoiqwtoqiuwoqowe");
//		list.add(d1);
		System.out.println(JSON.toJSONString(list,true));	
	}
}
