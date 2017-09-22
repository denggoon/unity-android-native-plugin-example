using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AndroidListner : MonoBehaviour {

    const string javaClassName = "com.jiwan.unityplugin.PluginClass";

    public TextMesh textMesh;
	public void CalledFromAndroid(string textReceived)
    {
        textMesh.text = textReceived;
    }

    public TextMesh buttonPressedMesh;
    public void CallNativeMsgBox()
    {
        Debug.Log("Button Was Pressed");
        buttonPressedMesh.text = "Button Was Pressed";

        using (AndroidJavaObject jo = new AndroidJavaObject(javaClassName))
        {
            jo.Call("NativeMsgBox");
        }
    }

    public TextMesh nativeMsgBoxMesh;
    public void NativeMsgBoxCalled(string msg)
    {
        nativeMsgBoxMesh.text = "NativeMsgBox Was Called in Native";
    }
}
