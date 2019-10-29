/**2019年6月20日
 * 86176
 */
package com.eda.pojo;

import lombok.Data;

/**
 * @author 86176
 *
 */
@Data
public class Hlxw {
	
	private int id;//ID
	private String content;//内容
	private String copyfrom;//发文机关：国务院办公厅
	private String title;//标题
	private String description;
	private String createTime;//成文日期
	private String source;

}
