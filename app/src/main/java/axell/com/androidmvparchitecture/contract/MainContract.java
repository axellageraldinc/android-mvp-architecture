package axell.com.androidmvparchitecture.contract;

import java.util.List;

import axell.com.androidmvparchitecture.model.Friend;

public interface MainContract {
    interface View{
        void showFriend(List<Friend> friendList);
        void clearInput();
    }
    interface Interactor{
        void saveFriend(Friend friend);
        List<Friend> getAllFriends();
    }
    interface Presenter{
        void saveFriend(Friend friend);
    }
}
