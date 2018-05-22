package axell.com.androidmvparchitecture.presenter;

import axell.com.androidmvparchitecture.contract.MainContract;
import axell.com.androidmvparchitecture.interactor.MainInteractorImpl;
import axell.com.androidmvparchitecture.model.Friend;

public class MainPresenterImpl implements MainContract.Presenter {

    private MainContract.View mainView;
    private MainContract.Interactor mainInteractor;

    public MainPresenterImpl(MainContract.View mainView) {
        this.mainView = mainView;
        this.mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void saveFriend(Friend friend) {
        mainInteractor.saveFriend(friend);
        mainView.showFriend(mainInteractor.getAllFriends());
        mainView.clearInput();
    }

}
