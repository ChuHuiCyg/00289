package com.run.treadmill.floatWindow;

import java.io.IOException;

import android.graphics.SurfaceTexture;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.os.Handler;
import android.app.Instrumentation;

import com.run.treadmill.HomeActivity;
import com.run.treadmill.R;
import com.run.treadmill.manager.SelfAudioManager;
import com.run.treadmill.selfdefView.VerticalSeekBar;
import com.run.treadmill.util.CTConstant;

//进入分享界面后悬浮窗口类
public class VolumeFloatWindow {
	
	private WindowManager mWindowManager;
	private WindowManager.LayoutParams wmParams;
	private LinearLayout mFloatWindow = null;
	
	private Activity mContext;
	private ImageView back_float = null;
	private boolean mFloatAdded = false;
	private int scn_w = -1;
	private int scn_h = -1;
	private int float_win_w = -1;
	private int float_win_h = -1;
	
	private long last_touch_time = 0;
	private int last_x = 0;
	private int last_y = 0;
	private static final String TAG = "BackFloatWindow";

	private FloatWindowManager mFloatWindowManager;
	private boolean mIsShow = true;

	private ImageView sb_media_volume_bk;
	private VerticalSeekBar mVerticalSeekBar;
	
	public VolumeFloatWindow(Context context) {

		mWindowManager = (WindowManager) ((Activity)context).getApplication().
			getSystemService(Context.WINDOW_SERVICE);
		mContext = (Activity)context;

	}
	
	public void startFloat(FloatWindowManager floatWindowManager) {
		Log.i(TAG, "startFloat");
		mFloatWindowManager = floatWindowManager;
		DisplayMetrics dm = new DisplayMetrics();
		mWindowManager.getDefaultDisplay().getMetrics(dm);

		scn_w = dm.widthPixels;
		scn_h = dm.heightPixels;
		Log.i(TAG,"__scn_w_____"+scn_w+"_scn_h__"+scn_h);
		// float_win_w = scn_w / 3;
		// float_win_h = 1080 * float_win_w / 1920;
		float_win_w = 65;
		float_win_h = 222;
		Log.i(TAG,"__float_win_w_____"+float_win_w+"_float_win_h__"+float_win_h);


		mFloatWindow = CreateFloatWindow(R.layout.volume_float_window, Gravity.LEFT | Gravity.TOP,
				0, 110, float_win_w, float_win_h);
		sb_media_volume_bk = (ImageView) mFloatWindow.findViewById(R.id.sb_media_volume_bk);
		mVerticalSeekBar = (VerticalSeekBar) mFloatWindow.findViewById(R.id.sb_media_volume);
		//wmParams = (WindowManager.LayoutParams)mFloatWindow.getLayoutParams();
		AddView(mFloatWindow);
		
		mVerticalSeekBar.setProgress( SelfAudioManager.getInstance(null).
				getCurrentPro(mVerticalSeekBar.getMax()) );
		mVerticalSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				SelfAudioManager.getInstance(null).setAudioVolume(progress, seekBar.getMax());
			}
		});
		
	}
	
	private LinearLayout CreateFloatWindow(int id, int gravity, int x, int y, int w, int h) {
		Log.i(TAG, "CreateFloatWindow");
		LinearLayout mWindow = (LinearLayout) GetView(id);
		WindowManager.LayoutParams Params = new WindowManager.LayoutParams();
		Params.type = LayoutParams.TYPE_PHONE;
		Params.format = PixelFormat.RGBA_8888; 
		Params.flags = LayoutParams.FLAG_NOT_FOCUSABLE | LayoutParams.FLAG_HARDWARE_ACCELERATED;      
		Params.gravity = gravity;       
		Params.x = x;
		Params.y = y;
		Params.width = w;
		Params.height = h;
		Params.windowAnimations = android.R.style.Animation_Translucent;
		setParams(Params);
		return mWindow;
	}
	
	public View GetView(int id) {
		View vv;
		LayoutInflater inflater = LayoutInflater.from(mContext.getApplication());
		vv = (LinearLayout) inflater.inflate(id, null);
		vv.measure(
			View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED), 
			View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED)
		);
		return vv;
	}
	
	private void setParams(WindowManager.LayoutParams param)
	{
		wmParams = param;
	}
	
	private synchronized void RemoveView(View view) {
		Log.i(TAG, "RemoveView");
		if (view == mFloatWindow) {
			if (mFloatAdded == false) {
				return;
			}
			mWindowManager.removeView(view);
			mFloatAdded = false;	
		} 
	}

	private synchronized void AddView(View view) {
		Log.i(TAG, "addView");
		if (view == mFloatWindow) {
			if (mFloatAdded == true) {
				return;
			}
			mWindowManager.addView(view, wmParams);
			mFloatAdded = true;
		}
	}
	
	public void stopFloat() {
		Log.i(TAG, " stopFloat");
		if(mFloatWindow != null && mFloatAdded) {
			RemoveView(mFloatWindow);
			mFloatWindow = null;
		}
		
	}
	
	/**
	 * 模拟发送按键事件
	 * @param KeyCode
	 */
	public static void simulateKey(final int KeyCode) {
		new Thread() {
			public void run() {
				try {
					Instrumentation inst = new Instrumentation();
					inst.sendKeyDownUpSync(KeyCode);
				} catch (Exception e) {
					Log.e("Exception when sendKeyDownUpSync", e.toString());
				}
			}
		}.start();
	}
	
	public void showFloatWindow() {
		mFloatWindow.setVisibility(View.VISIBLE);
	}

	public void hideFloatWindow() {
		mFloatWindow.setVisibility(View.GONE);
	}
	
	public boolean getFloatWindowIsShow() {
		if ( mFloatWindow.getVisibility() == View.GONE ) {
			return false; 
		} else {
			return true;
		}
	}
	
}
