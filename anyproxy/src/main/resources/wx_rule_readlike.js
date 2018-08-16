var fs = require("fs");

var path = "/Users/xuefeng/Desktop/anyproxy/logs";
var log = path + "/" +  "_interfaceLog.log";
console.log(log);

module.exports = {
  *beforeSendResponse(requestDetail, responseDetail) {
    const newResponse = responseDetail.response;
    var content = responseDetail.response.body.toString();
    if (requestDetail.url.indexOf('https://mp.weixin.qq.com/mp/getappmsgext') === 0) {
      console.info(content);
    }
    if(requestDetail.url.indexOf('__biz=') != -1){
      var autoNextPageMeta = getAutoNextPageMeta();
     console.info(content)
      newResponse.body = content.replace('</title>', '</title>' + autoNextPageMeta);	
    }
    return {
        response: newResponse
    };
  }
};

function getAutoNextPageMeta() {
	nextLink = "https://mp.weixin.qq.com/s/7g1QAdjQkg5RYdwsRRQpOw";
    return '<meta http-equiv="refresh" content="' + 10  + ';url=' + nextLink + '" />';
}
