package axell.com.androidmvparchitecture.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import axell.com.androidmvparchitecture.R;
import axell.com.androidmvparchitecture.contract.MainContract;
import axell.com.androidmvparchitecture.model.Friend;
import axell.com.androidmvparchitecture.presenter.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainContract.View, Button.OnClickListener {

    private MainContract.Presenter mainPresenter;

    private RecyclerView recyclerViewFriend;
    private EditText txtInputName, txtInputPhone;
    private Button btnSaveFriend;
    private RecyclerViewFriendAdapter recyclerViewFriendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenterImpl(this);
        initViews();
    }

    private void initViews(){
        txtInputName = findViewById(R.id.txtInputName);
        txtInputPhone = findViewById(R.id.txtInputPhone);
        btnSaveFriend = findViewById(R.id.btnSaveFriend);
        btnSaveFriend.setOnClickListener(this);
        recyclerViewFriend = findViewById(R.id.recyclerViewFriend);
    }

    @Override
    public void showFriend(List<Friend> friendList) {
        recyclerViewFriendAdapter = new RecyclerViewFriendAdapter(this, friendList);
        recyclerViewFriend.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFriend.setAdapter(recyclerViewFriendAdapter);
        recyclerViewFriendAdapter.notifyDataSetChanged();
    }

    @Override
    public void clearInput() {
        txtInputName.setText("");
        txtInputPhone.setText("");
        txtInputName.requestFocus();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSaveFriend:
                mainPresenter.saveFriend(new Friend(txtInputName.getText().toString(), txtInputPhone.getText().toString()));
                break;
        }
    }
}
