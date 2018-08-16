var fs = require("fs");

var path = "/Users/xuefeng/Desktop/anyproxy/logs";
var log = path + "/" +  "_interfaceLog.log";
console.log(log);

var config = {
    host: 'http://127.0.0.1:8080', // 服务器地址配置
    crawlHistory: true, // 是否采集列表历史数据
    crawlArticle: true, // 是否采集文章数据
    crawlComment: true, // 是否采集评论数据
    crawlLikeReadNum: true, // 是否采集文章的阅读量及点赞量
    autoNextScroll: true, // 是否自动下拉采取数据
    autoNextPage: true, // 是否自动文章翻页
    autoPostData: true, // 是否提交数据到服务器
    m: 3000, // 自动下拉的时间间隔 m ~ n 秒之间
    n: 5000,
    jumpInterval: 10, // 文章页跳转的时间间隔
    saveContentType: 'html',// 微信文章保存内容的形式: html/text
    localImg: true // 公众号的图片返回本地图片
}

module.exports = {
   *beforeSendResponse(requestDetail, responseDetail) {
        var newResponse = Object.assign({}, responseDetail.response);
        if (requestDetail.url.indexOf('https://mp.weixin.qq.com/mp/profile_ext') === 0) {
	    var contentType = responseDetail.response.header['Content-Type'];
      	if (contentType.indexOf('text/html') !== -1) {
      		var autoNextScrollJS = getAutoNextScrollJS();
      		newResponse.body += autoNextScrollJS;
        }
        if(contentType.indexOf('application/json' !== -1)) {
            console.info(responseDetail.response.body.toString());
        }
    }
   return {
     response: newResponse
   };
  }
};

function getAutoNextScrollJS() {
    var nextJS = '';
    nextJS += '<script type="text/javascript">';
    nextJS += '    var end = document.createElement("p");';
    nextJS += '    document.body.appendChild(end);';
    nextJS += '    (function scrollDown(){';
    nextJS += '        end.scrollIntoView();';
    nextJS += '        var loadMore = document.getElementsByClassName("loadmore with_line")[0];';
    nextJS += '        if (loadMore.style.display) {';
    nextJS += '            setTimeout(scrollDown,Math.floor(Math.random()*('+config.n+'-'+config.m+')+'+config.m+'));';
    nextJS += '        } ';
    nextJS += '    })();';
    nextJS += '<\/script>';
    return nextJS;
}
