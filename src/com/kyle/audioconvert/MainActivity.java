package com.kyle.audioconvert;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.zc.RecordDemo.Mp3Conveter;

import net.sourceforge.lame.Lame;

import vavi.sound.pcm.resampling.ssrc.SSRC;


import android.app.Activity;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class MainActivity extends Activity {

	public String dir = Environment.getExternalStorageDirectory().getPath()
			+ "/AudioRecordText/";;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.d("Kyle","start convert");
		Mp3Conveter mConveter = new Mp3Conveter();
		mConveter.encodeFile(dir+"APT-08-24-041307.wav", dir+"APT-08-24-041307.mp3");
		mConveter.destroyEncoder();
		
        
	}
	
	public void SSRCConvert(){
		String[] argss = {"--rate","8000",dir+"APT-08-21-024617.wav",dir+"APT-08-21-024617-8000java.wav"};
        try {
			new SSRC(argss);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
