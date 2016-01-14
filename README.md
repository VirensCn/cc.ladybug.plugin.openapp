#说明：
    cordova插件，根据包名来打开其他的软件
#安装:
    cordova plugin add https://git.oschina.net/yyzh/cc.ladybug.openapp.git
#使用：
    navigator.OpenApp("app的包名",function(e){
        // 打开成功
    },function(e){
        // 打开失败
    });