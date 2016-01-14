package cc.ladybug.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class OpenApp extends CordovaPlugin {
	public static final String TAG = "OpenApp";

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		Activity activity = this.cordova.getActivity();
		if (!args.isNull(0)) {
            String appPackage = args.getString(0);
            Log.e(TAG, "will open zhe app's package:" + appPackage);
            try {
                Intent intent = activity.getPackageManager().getLaunchIntentForPackage(appPackage);
                if (intent != null) {
                    activity.startActivity(intent);
                    callbackContext.success("启动成功");
                    return true;
                } else {
                    callbackContext.error("当前没有该软件.");
                    return false;
                }
            } catch (Exception e) {
                callbackContext.error("启动时发生错误.");
                return false;
            }
        } else {
            callbackContext.error("包名不可为空!");
            return false;
        }
	}
}
