package affle.com.wcart.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import affle.com.wcart.R;
import affle.com.wcart.appsanddevices.fitbit.ManagerFitbit;
import affle.com.wcart.appsanddevices.runkeeper.ManagerRunKeeper;
import affle.com.wcart.customviews.CustomTypefaceTextView;
import affle.com.wcart.models.request.ReqConnectDisconnectApps;
import affle.com.wcart.models.response.ResBase;
import affle.com.wcart.network.ApiClient;
import affle.com.wcart.network.IApiClient;
import affle.com.wcart.network.MethodFactory;
import affle.com.wcart.network.NetworkConnection;
import affle.com.wcart.network.ServiceConstants;
import affle.com.wcart.preference.PreferenceKeys;
import affle.com.wcart.ui.activities.HomeActivity;
import affle.com.wcart.utils.AppConstants;
import affle.com.wcart.utils.AppDialog;
import affle.com.wcart.utils.ToastUtils;
import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by akash on 15/6/16.
 */
public class ConnectAppsAndDevicesFragment extends BaseFragment {


    @BindView(R.id.iv_runkeeper)
    ImageView ivRunkeeper;
    @BindView(R.id.iv_fitbit)
    ImageView ivFibit;
    @BindView(R.id.tv_tap_on_runkeeper)
    CustomTypefaceTextView tvTapOnRunkeeper;
    @BindView(R.id.tv_connect_runkeeper)
    CustomTypefaceTextView tvConnectRunkeeper;
    @BindView(R.id.tv_tap_on_fitbit)
    CustomTypefaceTextView tvTapOnFitbit;
    @BindView(R.id.tv_connect_fitbit)
    CustomTypefaceTextView tvConnectFitbit;
    private ManagerRunKeeper managerRunKeeper;
    private ManagerFitbit managerFitbit;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connect_apps_and_devices, container, false);
        return view;
    }

    @Override
    protected void initViews() {
        ((HomeActivity) getActivity()).setActionBarTitle(R.string.title_connect_apps_and_devices);
    }

    @Override
    protected void initVariables() {
        managerRunKeeper = ManagerRunKeeper.getInstance(getActivity());
        managerFitbit = ManagerFitbit.getInstance((HomeActivity) mActivity);
        /*((HomeActivity) mActivity).setVisibilityBottomLayout(false);*/   // testing command for bottom bar view hiding
        ivFibit.setOnClickListener(this);
        ivRunkeeper.setOnClickListener(this);
        if ((mAppSharedPreference.getString(PreferenceKeys.KEY_CONNECTED_APP, "")).equals(AppConstants.FITBIT_CONNECTED)) {
            tvConnectFitbit.setText(R.string.txt_connected);
            tvConnectRunkeeper.setText(R.string.txt_disconnected);
        } else if ((mAppSharedPreference.getString(PreferenceKeys.KEY_CONNECTED_APP, "")).equals(AppConstants.RUNKEEPER_CONNECTED)) {
            tvConnectFitbit.setText(R.string.txt_disconnected);
            tvConnectRunkeeper.setText(R.string.txt_connected);
        } else if ((mAppSharedPreference.getString(PreferenceKeys.KEY_CONNECTED_APP, "")).equals(AppConstants.NO_APP_CONNECTED)) {
            tvConnectFitbit.setText(R.string.txt_disconnected);
            tvConnectRunkeeper.setText(R.string.txt_disconnected);
        } else {
            tvConnectFitbit.setText(R.string.txt_disconnected);
            tvConnectRunkeeper.setText(R.string.txt_disconnected);
        }
        if (getArguments() != null) {
            managerFitbit.saveTokenToServer(getArguments().getString("accessToken"), getArguments().getString("userId"), this);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.tv_connect_runkeeper, R.id.tv_connect_fitbit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_connect_runkeeper:
                if (NetworkConnection.isNetworkConnected(mActivity)) {
                    if ((mAppSharedPreference.getString(PreferenceKeys.KEY_CONNECTED_APP, "")).equals(AppConstants.RUNKEEPER_CONNECTED))
                        connectDisconnetApp(AppConstants.RUNKEEPER_CONNECTED);
                } else {
                    ToastUtils.showShortToast(mActivity, R.string.err_network_connection);
                }
                break;
            case R.id.tv_connect_fitbit:
                if (NetworkConnection.isNetworkConnected(mActivity)) {
                    if ((mAppSharedPreference.getString(PreferenceKeys.KEY_CONNECTED_APP, "")).equals(AppConstants.FITBIT_CONNECTED))
                        connectDisconnetApp(AppConstants.FITBIT_CONNECTED);
                } else {
                    ToastUtils.showShortToast(mActivity, R.string.err_network_connection);
                }
                break;
            case R.id.iv_fitbit:
                if (getActivity().isFinishing()) return;
                managerFitbit.connectFitbit(mActivity);
                break;
            case R.id.iv_runkeeper:
                if (getActivity().isFinishing()) return;
                managerRunKeeper.connectRunKeeper(mActivity, this);
                break;
        }
    }

    /**
     * Setting whether connected or not
     */
    public void setData() {
        if ((mAppSharedPreference.getString(PreferenceKeys.KEY_CONNECTED_APP, "")).equals(AppConstants.FITBIT_CONNECTED)) {
            tvConnectFitbit.setText(R.string.txt_connected);
            tvConnectRunkeeper.setText(R.string.txt_disconnected);
        } else if ((mAppSharedPreference.getString(PreferenceKeys.KEY_CONNECTED_APP, "")).equals(AppConstants.RUNKEEPER_CONNECTED)) {
            tvConnectFitbit.setText(R.string.txt_disconnected);
            tvConnectRunkeeper.setText(R.string.txt_connected);
        }

    }

    /**
     * Connected/Disconnnetced App (Fitbit/Runkeeper) from server
     *
     * @param connectApp
     */
    private void connectDisconnetApp(String connectApp) {
        AppDialog.showProgressDialog(mActivity, true);
        IApiClient client = ApiClient.getApiClient();
        ReqConnectDisconnectApps reqConnectDisconnectApps = new ReqConnectDisconnectApps();
        reqConnectDisconnectApps.setUserID(mAppSharedPreference.getString(PreferenceKeys.KEY_USER_ID, ""));
        reqConnectDisconnectApps.setServiceKey(mAppSharedPreference.getString(PreferenceKeys.KEY_SERVICE_KEY, ServiceConstants.SERVICE_KEY));
        reqConnectDisconnectApps.setMethod(MethodFactory.CONNECT_DISCONNECT_APP.getMethod());
        if (connectApp.equals(AppConstants.FITBIT_CONNECTED))
            reqConnectDisconnectApps.setIsFitbitConnect("0");
        else if (connectApp.equals(AppConstants.RUNKEEPER_CONNECTED))
            reqConnectDisconnectApps.setIsRunkeeperConnect("0");
        Call<ResBase> call = client.connectDisconnectApp(reqConnectDisconnectApps);
        call.enqueue(new Callback<ResBase>() {
            @Override
            public void onResponse(Call<ResBase> call, Response<ResBase> response) {
                AppDialog.showProgressDialog(mActivity, false);
                ResBase resBase = response.body();
                if (resBase != null) {
                    if (resBase.getSuccess() == ServiceConstants.SUCCESS) {
                        if ((mAppSharedPreference.getString(PreferenceKeys.KEY_CONNECTED_APP, "")).equals(AppConstants.FITBIT_CONNECTED)) {
                            tvConnectFitbit.setText(R.string.txt_disconnected);
                        } else if ((mAppSharedPreference.getString(PreferenceKeys.KEY_CONNECTED_APP, "")).equals(AppConstants.RUNKEEPER_CONNECTED)) {
                            tvConnectRunkeeper.setText(R.string.txt_disconnected);
                        }
                        mAppSharedPreference.setString(PreferenceKeys.KEY_CONNECTED_APP, AppConstants.NO_APP_CONNECTED);
                    } else {
                        ToastUtils.showShortToast(mActivity, resBase.getErrstr());
                    }
                } else {
                    ToastUtils.showShortToast(mActivity, R.string.err_network_connection);
                }
            }

            @Override
            public void onFailure(Call<ResBase> call, Throwable t) {
                AppDialog.showProgressDialog(mActivity, false);
                ToastUtils.showShortToast(mActivity, R.string.err_network_connection);
            }
        });
    }
}
