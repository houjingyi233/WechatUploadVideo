package com.example.xposedwechat;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import com.example.xposedwechat.countmd5;

public class wechat implements IXposedHookLoadPackage 
{	
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable
    {
        if (!lpparam.packageName.equals("com.tencent.mm"))
            return;
        XposedBridge.log("Loaded app: " + lpparam.packageName);
        try 
        {
        	XposedHelpers.findAndHookMethod("com.tencent.mm.ui.LauncherUI", lpparam.classLoader, "onResume", new XC_MethodHook()
            {  
        		protected void beforeHookedMethod(MethodHookParam methodHookParam) 
        		{ 
        			//这里获取到的就是LauncherUI对象实例了
        			Object obj=methodHookParam.thisObject;
        			Activity UploadActivity=(Activity)obj;
        			String videoImg="/data/local/tmp/weixin_share.jpg";
         			String videoPath="/data/local/tmp/weixin_share.mp4";
         			File imgFile=new File(videoImg);
         			File videoFile=new File(videoPath);
         			if(videoFile.exists()&&imgFile.exists())
         			{
         				try
         				{
         					String md5=countmd5.g(videoFile);
         					String activityName="com.tencent.mm.plugin.sns.ui.SightUploadUI";
         					Intent intent=new Intent();
         					intent.setClassName(UploadActivity.getApplicationContext(),activityName);
         					intent.putExtra("sight_md5",md5);
         					intent.putExtra("KSightDraftEntrance",false);
         					intent.putExtra("KSightPath",videoPath);
         					intent.putExtra("KSightThumbPath",videoImg);
         					intent.putExtra("Kdescription","TestTestTest...");
         					UploadActivity.startActivity(intent);
         					Log.i("test","successful!");
         				}
         				catch(Throwable e)
         				{
         					Log.i("test","a error:"+Log.getStackTraceString(e));
         				}
         			}
         			else
         			{
         				Log.i("test","file not exist...");
         			}
        		}
            });  
        } 
        catch (Throwable t) 
        {
            throw t;
        }
    }
}
