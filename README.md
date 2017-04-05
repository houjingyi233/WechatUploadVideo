# WechatUploadVideo
基于xposed框架实现的本地视频发布到朋友圈，原理是根据别人一篇博客：http://blog.csdn.net/jiangwei0910410003/article/details/53045634

使用前请确保手机获得root权限并安装了xposed框架。本框架在微信6.3.9版本下通过测试，微信6.3.9下载：https://pan.baidu.com/s/1nvPVnoH  

![image](https://github.com/houjingyi233/Screenshots/blob/master/QQ%E5%9B%BE%E7%89%8720170405152000.png)  

在代码中，视频文件和封面图片都在/data/local/tmp/路径下，名称分别为weixin_share.mp4和weixin_share.jpg。另外根据微信方面的规定，小视频长度不能超过15s，大小不能超过1M。有需要的话请修改源代码并重新编译，在bin目录下有编译好的apk，演示gif如下。  

<img src="https://github.com/houjingyi233/Screenshots/blob/master/test.gif" width = "200" height = "400" alt="图片名称" align=center />
  
