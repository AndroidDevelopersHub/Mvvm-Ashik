package co.codesurfer.mvvmashik.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.util.ArrayUtils;

import java.util.Collection;

import co.codesurfer.mvvmashik.Model.User;
import co.codesurfer.mvvmashik.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    User[] usersData;

    public UserAdapter(User[] usersData) {
        this.usersData = usersData;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_list, parent, false);
        return new UserViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.name.setText(usersData[position].getLogin());

    }

    @Override
    public int getItemCount() {
        return usersData.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }


}
