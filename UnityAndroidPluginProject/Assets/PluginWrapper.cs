using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PluginWrapper : MonoBehaviour
{

    // Use this for initialization
    void Start()
    {
        TextMesh textMesh = GetComponent<TextMesh>();
        var plugin = new AndroidJavaClass("com.jiwan.unityplugin.PluginClass");

        textMesh.text = plugin.CallStatic<string>("GetTextFromPlugin", 7);
    }

    private void Update()
    {
        if(Input.GetKeyDown(KeyCode.Escape))
        {
            if (!Application.isEditor)
                System.Diagnostics.Process.GetCurrentProcess().Kill();

            //Application.Quit은 앱크래시나는 버그가 있어 이렇게 처리
        }

    }
}
