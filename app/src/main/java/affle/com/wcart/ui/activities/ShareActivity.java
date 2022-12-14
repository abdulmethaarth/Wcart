package affle.com.wcart.ui.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sromku.simple.fb.SimpleFacebook;

import java.util.Locale;

import affle.com.wcart.R;
import affle.com.wcart.customviews.CustomTypefaceButton;
import affle.com.wcart.customviews.CustomTypefaceTextView;
import affle.com.wcart.interfaces.IOnShareResult;
import affle.com.wcart.models.request.ReqGetUserPointsByTime;
import affle.com.wcart.models.response.ResGetUserPointsByTime;
import affle.com.wcart.network.ApiClient;
import affle.com.wcart.network.IApiClient;
import affle.com.wcart.network.MethodFactory;
import affle.com.wcart.network.NetworkConnection;
import affle.com.wcart.network.ServiceConstants;
import affle.com.wcart.preference.PreferenceKeys;
import affle.com.wcart.utils.AppDialog;
import affle.com.wcart.utils.Logger;
import affle.com.wcart.utils.ServiceUtils;
import affle.com.wcart.utils.SocialNetworkUtils;
import affle.com.wcart.utils.ToastUtils;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShareActivity extends BaseActivity implements IOnShareResult {

	@BindView(R.id.tv_title)
	TextView tvTitle;
	@BindView(R.id.iv_back)
	ImageView ivBack;
	@BindView(R.id.tv_share_on_fb)
	TextView tvShareOnFb;
	@BindView(R.id.tv_points)
	CustomTypefaceTextView tvPoints;
	@BindView(R.id.tv_distance)
	CustomTypefaceTextView tvDistance;
	@BindView(R.id.tv_distance_unit)
	CustomTypefaceTextView tvDistanceUnit;
	@BindView(R.id.tv_calories)
	CustomTypefaceTextView tvCalories;
	@BindView(R.id.rl_fitness_info)
	RelativeLayout rlFitnessInfo;
	@BindView(R.id.tv_today)
	CustomTypefaceButton tvToday;
	@BindView(R.id.tv_week)
	CustomTypefaceButton tvWeek;
	@BindView(R.id.tv_month)
	CustomTypefaceButton tvMonth;
	@BindView(R.id.tv_year)
	CustomTypefaceButton tvYear;
	@BindView(R.id.tv_lifetime)
	CustomTypefaceButton tvLifetime;
	@BindView(R.id.iv_image_at_top)
	ImageView ivImageAtTop;
	@BindView(R.id.et_share_content)
	EditText etShareContent;
	//private String mImagePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share);
		super.initData();
	}

	@Override
	protected void initViews() {
		//mImagePath = getIntent().getStringExtra(AppConstants.TAG_IMAGE_PATH);
		tvTitle.setText(R.string.txt_share_activities);

		//set listeners
		ivBack.setOnClickListener(this);
		tvShareOnFb.setOnClickListener(this);
		tvToday.setOnClickListener(this);
		tvWeek.setOnClickListener(this);
		tvMonth.setOnClickListener(this);
		tvYear.setOnClickListener(this);
		tvLifetime.setOnClickListener(this);
		if (!mAppSharedPreference.getString(PreferenceKeys.KEY_HOME_IMAGE, "").isEmpty()) {
			Glide.with(this)
					.load(mAppSharedPreference.getString(PreferenceKeys.KEY_HOME_IMAGE, ""))
					.centerCrop()
					.placeholder(R.drawable.img_placeholder)
					.into(ivImageAtTop);
		}
	}

	@Override
	protected void initVariables() {
		tvCalories.setText(mAppSharedPreference.getString(PreferenceKeys.KEY_CALORIES, "0"));
		tvDistance.setText(mAppSharedPreference.getString(PreferenceKeys.KEY_DISTANCE, "0"));
		tvDistanceUnit.setText(mAppSharedPreference.getString(PreferenceKeys.KEY_DISTANCE_UNIT, "KM"));
		tvPoints.setText(mAppSharedPreference.getString(PreferenceKeys.KEY_POINTS, "0"));
	}

	/**
	 * Method used to reset all buttons to their default state
	 */
	private void deselectAllDurationButtons() {
		tvToday.setSelected(false);
		tvWeek.setSelected(false);
		tvMonth.setSelected(false);
		tvYear.setSelected(false);
		tvLifetime.setSelected(false);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.iv_back:
				onBackPressed();
				break;
			case R.id.tv_share_on_fb:
				try {
					rlFitnessInfo.setDrawingCacheEnabled(true);
					rlFitnessInfo.buildDrawingCache(true);
					rlFitnessInfo.setDrawingCacheQuality(RelativeLayout.DRAWING_CACHE_QUALITY_HIGH);
					Bitmap bitmap = Bitmap.createBitmap(rlFitnessInfo.getDrawingCache());
					rlFitnessInfo.setDrawingCacheEnabled(false);
					if (NetworkConnection.isNetworkConnected(this)) {
						SocialNetworkUtils.getInstance(this).shareTextOnFacebook(this, SimpleFacebook.getInstance(this), etShareContent.getText().toString().trim(), bitmap);
					} else {
						ToastUtils.showShortToast(this, R.string.err_network_connection);
					}
				}
				catch(Exception e)
				{
					Toast.makeText(getApplicationContext(),
							e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
				break;
			//today/week/month/year
			case R.id.tv_today:
				deselectAllDurationButtons();
				tvToday.setSelected(true);
				getUserPointsByTime("today");
				break;
			case R.id.tv_week:
				deselectAllDurationButtons();
				tvWeek.setSelected(true);
				getUserPointsByTime("week");
				break;
			case R.id.tv_month:
				deselectAllDurationButtons();
				tvMonth.setSelected(true);
				getUserPointsByTime("month");
				break;
			case R.id.tv_year:
				deselectAllDurationButtons();
				tvYear.setSelected(true);
				getUserPointsByTime("year");
				break;
			case R.id.tv_lifetime:
				deselectAllDurationButtons();
				tvLifetime.setSelected(true);
				getUserPointsByTime("lifetime");
				break;
		}
	}

	@Override
	public void onShareSuccess() {
		ServiceUtils.shareAndInvite(this, new ProgressDialog(this), mAppSharedPreference, ServiceConstants.TYPE_SHARE, null);
	}

	@Override
	public void onShareFailure(String message) {
		ToastUtils.showShortToast(this, getString(R.string.err_share_unsuccessful));
		Logger.e("msg -----> " + message);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		SimpleFacebook.getInstance(this).onActivityResult(requestCode, resultCode, data);
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void getUserPointsByTime(String time) {
		AppDialog.showProgressDialog(this, true);
		IApiClient client = ApiClient.getApiClient();
		ReqGetUserPointsByTime reqGetUserPointsByTime = new ReqGetUserPointsByTime();
		reqGetUserPointsByTime.setMethod(MethodFactory.GET_FS_POINTS_BY_TIME.getMethod());
		reqGetUserPointsByTime.setServiceKey(mAppSharedPreference.getString(PreferenceKeys.KEY_SERVICE_KEY, ""));
		reqGetUserPointsByTime.setUserID(mAppSharedPreference.getString(PreferenceKeys.KEY_USER_ID, ""));
		reqGetUserPointsByTime.setPointTime(time);
		Call<ResGetUserPointsByTime> call = client.getUserPointsByTime(reqGetUserPointsByTime);
		call.enqueue(new Callback<ResGetUserPointsByTime>() {
			@Override
			public void onResponse(Call<ResGetUserPointsByTime> call, Response<ResGetUserPointsByTime> response) {
				AppDialog.showProgressDialog(ShareActivity.this, false);
				ResGetUserPointsByTime resGetUserPointsByTime = response.body();
				if (resGetUserPointsByTime != null) {
					if (resGetUserPointsByTime.getSuccess() == ServiceConstants.SUCCESS) {

						tvPoints.setText(resGetUserPointsByTime.getTotalPoints());
						tvDistance.setText(String.format(Locale.getDefault(), "%.1f", Float.parseFloat(resGetUserPointsByTime.getDistance())));
						tvCalories.setText(resGetUserPointsByTime.getCalories());
					} else {
						ToastUtils.showShortToast(ShareActivity.this, resGetUserPointsByTime.getErrstr());
					}
				} else {
					ToastUtils.showShortToast(ShareActivity.this, R.string.err_network_connection);
				}

			}

			@Override
			public void onFailure(Call<ResGetUserPointsByTime> call, Throwable t) {
				AppDialog.showProgressDialog(ShareActivity.this, false);
				ToastUtils.showShortToast(ShareActivity.this, R.string.err_network_connection);
			}
		});
	}
}
