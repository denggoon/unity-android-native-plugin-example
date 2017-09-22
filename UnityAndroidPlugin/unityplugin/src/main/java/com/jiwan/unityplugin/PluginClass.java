package com.jiwan.unityplugin;

/**
 * Created by Jiwan on 2017-09-22.
 */

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class PluginClass extends UnityPlayerActivity {

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
}
