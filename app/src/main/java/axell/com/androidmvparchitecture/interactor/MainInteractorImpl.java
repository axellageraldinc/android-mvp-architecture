package axell.com.androidmvparchitecture.interactor;

import java.util.ArrayList;
import java.util.List;

import axell.com.androidmvparchitecture.contract.MainContract;
import axell.com.androidmvparchitecture.model.Friend;

public class MainInteractorImpl implements MainContract.Interactor {

    private List<Friend> friendList = new ArrayList<>();

    @Override
    public void saveFriend(Friend friend) {
        friendList.add(friend);
    }

    @Override
    public List<Friend> getAllFriends() {
        return friendList;
    }

}
