package fpoly.com.duan1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpoly.com.duan1.R;
import fpoly.com.duan1.model.DiemCao;
import fpoly.com.duan1.model.XepHang;

public class BangrXepHangAdapter extends RecyclerView.Adapter<BangrXepHangAdapter.BangXepHangHolder> {
    private List<XepHang> diemCaos;
    private Context context;

    public BangrXepHangAdapter(List<XepHang> diemCaos, Context context) {
        this.diemCaos = diemCaos;
        this.context = context;
    }

    @NonNull
    @Override
    public BangrXepHangAdapter.BangXepHangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_hang, parent,false);
        return new BangXepHangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BangrXepHangAdapter.BangXepHangHolder holder, int position) {

        holder.tvStt.setText((position + 1) + "");
        holder.tvPlayer.setText(diemCaos.get(position).getPlayer());
        holder.tvTienThuong.setText(convertTien(Integer.parseInt(diemCaos.get(position).getDiem())));


    }

    @Override
    public int getItemCount() {
        return diemCaos.size();
    }

    public class BangXepHangHolder extends RecyclerView.ViewHolder {
        TextView tvStt;
        TextView tvPlayer;
        TextView tvTienThuong;

        public BangXepHangHolder(@NonNull View itemView) {
            super(itemView);


            tvStt = (TextView) itemView.findViewById(R.id.tvStt);
            tvPlayer = (TextView) itemView.findViewById(R.id.tvPlayer);
            tvTienThuong = (TextView) itemView.findViewById(R.id.tvTienThuong);

        }
    }

    public String convertTien(int tienThuong) {
        if (tienThuong == 0) {
            return "0";
        } else if (tienThuong < 1000000) {
            return tienThuong / 1000 + "." + "000";
        } else {
            return tienThuong / 1000000 + "." + "000.000";
        }
    }
}
