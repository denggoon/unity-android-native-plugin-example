package com.jiwan.unityplugin;

/**
 * Created by Jiwan on 2017-09-22.
 */

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

//안드로이드 메시지 박스 용
import android.app.AlertDialog;
import android.view.ContextThemeWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

//Log.d 로그용
import android.util.Log;

public class PluginClass  extends  UnityPlayerActivity{

    //Build > Make Module unityPlugin을 선택하여 unityplugin/build/intermediates/bundles/debug에 있는 androidmanifest.xml과 classes.jar를 복사
    public static String GetTextFromPlugin(int number) {
        //유니티에서 안드로이드로
        CallUnityFunction();
        return "Number is " + number;
    }

    public static void CallUnityFunction()
    {
        //안드로이드에서 유니티로
        UnityPlayer.UnitySendMessage("Main Camera", "CalledFromAndroid", "Hello Unity! This is Android");
    }

    public void NativeMsgBox()
    {
        Log.d("Jiwan", "NativeMsgBox Called");
        UnityPlayer.UnitySendMessage("Main Camera", "NativeMsgBoxCalled", "");
        OpenDialogBox();
    }

    void OpenDialogBox()
    {
        AlertDialog.Builder messagePopup = new AlertDialog.Builder(new ContextThemeWrapper(UnityPlayer.currentActivity, android.R.style.Theme_Holo_Dialog));
        messagePopup.setTitle("MessagePopup");
        messagePopup.setMessage("Message");
        messagePopup.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //UnityPlayer.UnitySendMessage("AndroidMessagePopup", "OnMessagePopUpCallBack", "0");
            }
        });
        messagePopup.setOnKeyListener(KeyListener);
        messagePopup.setCancelable(false);
        messagePopup.show();
    }

    private static DialogInterface.OnKeyListener KeyListener = new OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                Log.d("AndroidNative", "AndroidPopUp");
                UnityPlayer.UnitySendMessage("AndroidMessagePopup", "OnMessagePopUpCallBack", "0");
                UnityPlayer.UnitySendMessage("AndroidDialogPopup", "OnDialogPopUpCallBack", "1");
                UnityPlayer.UnitySendMessage("AndroidRateUsPopUp", "OnRatePopUpCallBack", "2");
                dialog.dismiss();
            }
            return false;
        }
    };
}
