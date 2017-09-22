using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AndroidListner : MonoBehaviour {

    public TextMesh textMesh;
	public void CalledFromAndroid(string textReceived)
    {
        textMesh.text = textReceived;
    }
}
