package com.visualcamp.plugin.plugintest;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {

  @Override
  public boolean dispatchKeyEvent(KeyEvent event) {
    String keyCodeInt = String.valueOf(event.getKeyCode());

    UnityPlayer.UnitySendMessage("Main Camera", "keyreceive", keyCodeInt);
    return super.dispatchKeyEvent(event);
  }

  /**
   * 플러그인 함수를 유니티에서 호출 할 때 필요한 것
   *
   * 유니티 2017.3 기준
   *
   * Assets / Plugins / Android 폴더에 플러그인 jar 파일이 있어야함.
   * Material 이라는 오브젝트에 추가된 스크립트에 onText 함수가 구현되어있어야함
   *
   *
   *
   * 컨텍스트가 필요한 함수인 경우
   *
   * 	  현재 플레이 되고있는 유니티 프로그램 자체를 가져오기
   * 	  AndroidJavaClass unityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
   *
   * 	  현재 포그라운드에 있는 액티비티 가져오기
   * 	  activity = unityPlayer.GetStatic<AndroidJavaObject>("currentActivity");
   *
   * 	  현재 액티비티를 통해 앱의 컨텍스트를 가져오기 (context 쓸때 필요함)
   * 	  app = activity.Call<AndroidJavaObject>("getApplicationContext");
   *
   *
   *  컨텍스트가 필요 없는 함수
   *
   * 	  필요한 함수가 있는 클래스 가져오기
   * 	  vrexPlugin = new AndroidJavaObject("camp.visual.gazereceiverplugin.MainActivity"); // Manifest 등록 ?
   *
   * 	  함수 사용하기
   * 	  text.text = vrexPlugin.Call<string> ("GetTextPlugin", 99);
   *
   */
  public static String GetTextPlugin(int number) {
    Log.e("qwdqwd" , "qwdqwd GetTextPlugin");
    UnityPlayer.UnitySendMessage("Material", "onText", "4");
    return "Number is " + number;
  }

}
