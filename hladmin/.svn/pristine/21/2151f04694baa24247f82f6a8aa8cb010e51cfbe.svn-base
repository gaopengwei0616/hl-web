/* 
* @Author: anchen
* @Date:   2015-07-11 00:03:32
* @Last Modified by:   anchen
* @Last Modified time: 2015-07-12 22:08:47
*/

function myHelp() {
    alert("help!");
}
function logout() {
    if(!confirm("是否退出")){
        return;
    }
    window.location.href="login";
}

/**
 * 休眠函数
 * @param n
 */
function sleep(n) {
    var start = new Date().getTime();
    while (true) {
        if (new Date().getTime() - start > n) {
            break;
        }
    }
}


/**
 * 获取url参数方法
 * @param name url的参数名称
 */
function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}
/**
 * 添加站点
 */
function changUrl(url) {
    window.location.href = url;
}
