package affle.com.wcart.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import affle.com.wcart.R;
import affle.com.wcart.customviews.CustomTypefaceTextView;
import affle.com.wcart.models.response.ResCashBackHistory;
import affle.com.wcart.network.ServiceConstants;

/**
 * Created by apps on 9/10/16.
 */

public class CashbackHistoryAdapterPending extends RecyclerView.Adapter<CashbackHistoryAdapterPending.ViewHolder> {
    private Activity mActivity;
    private ArrayList<ResCashBackHistory.CashBackDatum> mCashBackCompletedList;

    public CashbackHistoryAdapterPending(Activity mActivity, ArrayList<ResCashBackHistory.CashBackDatum> mCashBackCompletedList) {
        this.mActivity = mActivity;
        this.mCashBackCompletedList = mCashBackCompletedList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cashback_history, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvProductName.setText(mCashBackCompletedList.get(position).getName());
        //holder.tvCashbackYouGot.setText(mCashBackCompletedList.get(position).getAmount());
        //holder.tvRedeemedFsPoints.setText(mCashBackCompletedList.get(position).getRedeemPoint());
        holder.tvOrderNumberValue.setText(mCashBackCompletedList.get(position).getOrderID());
        holder.llExpectedDate.setVisibility(View.VISIBLE);
        holder.tvCashbackYouGotValue.setText("Rs. " + mCashBackCompletedList.get(position).getAmount());
        holder.tvRedeemedFsPointsValue.setText(mCashBackCompletedList.get(position).getRedeemPoint());
        if (mCashBackCompletedList.get(position).getAffilateType().equals(ServiceConstants.AFFILIATE_TYPE_FS_STORE)) {
            holder.ivProductType.setImageResource(R.drawable.logo);
        } else if (mCashBackCompletedList.get(position).getAffilateType().equals(ServiceConstants.AFFILIATE_TYPE_FLIPKART)) {
            holder.ivProductType.setImageResource(R.drawable.ic_fc_);
        } else if (mCashBackCompletedList.get(position).getAffilateType().equals(ServiceConstants.AFFILIATE_TYPE_SNAPDEAL)) {
            holder.ivProductType.setImageResource(R.drawable.ic_sd);
        }
        try {
            Date simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(mCashBackCompletedList.get(position).getCreatedTime());
            SimpleDateFormat dtFormat = new SimpleDateFormat("MMM dd, yyyy");
            String date = dtFormat.format(simpleDateFormat);
            holder.tvOrderDate.setText(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(simpleDateFormat);
            cal.add(Calendar.DATE, 2); //minus number would decrement the days
            String ExpectedDate = dtFormat.format(cal.getTime());
            holder.tvExpectedDateValue.setText(ExpectedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return mCashBackCompletedList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivProductType;
        CustomTypefaceTextView tvRedeemedFsPoints;
        CustomTypefaceTextView tvExpectedDate;
        CustomTypefaceTextView tvExpectedDateValue;
        CustomTypefaceTextView tvProductName;
        CustomTypefaceTextView tvOrderNumberValue;
        CustomTypefaceTextView tvCashbackYouGot;
        CustomTypefaceTextView tvCashbackYouGotValue;
        LinearLayout llExpectedDate;
        CustomTypefaceTextView tvOrderDate;
        CustomTypefaceTextView tvRedeemedFsPointsValue;

        public ViewHolder(View itemView) {
            super(itemView);
            tvOrderDate = (CustomTypefaceTextView) itemView.findViewById(R.id.tv_order_date);
            tvRedeemedFsPoints = (CustomTypefaceTextView) itemView.findViewById(R.id.tv_redeemed_fs_points);
            tvExpectedDateValue = (CustomTypefaceTextView) itemView.findViewById(R.id.tv_expected_date_value);
            tvExpectedDate = (CustomTypefaceTextView) itemView.findViewById(R.id.tv_expected_date);
            tvProductName = (CustomTypefaceTextView) itemView.findViewById(R.id.tv_product_name_cahback_history);
            tvCashbackYouGot = (CustomTypefaceTextView) itemView.findViewById(R.id.tv_cashback_you_got);
            tvOrderNumberValue = (CustomTypefaceTextView) itemView.findViewById(R.id.tv_order_number_value);
            ivProductType = (ImageView) itemView.findViewById(R.id.iv_product_type);
            llExpectedDate = (LinearLayout) itemView.findViewById(R.id.ll_expected_date);
            tvCashbackYouGotValue = (CustomTypefaceTextView) itemView.findViewById(R.id.tv_cashback_you_got_value);
            tvRedeemedFsPointsValue = (CustomTypefaceTextView) itemView.findViewById(R.id.tv_redeemed_fs_points_value);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
